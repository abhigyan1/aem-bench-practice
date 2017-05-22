package com.example.core.listeners;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jcr.AccessDeniedException;
import javax.jcr.InvalidItemStateException;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.ReferentialIntegrityException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONException;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.search.QueryBuilder;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.example.core.GetDamAssets;
import com.example.core.Searching;
import com.example.core.SolrOperations;
import com.example.core.UploadingAsset;

@Component
@Service
@Property(name="event.topics",value= ReplicationAction.EVENT_TOPIC)
public class ReplicationContent  implements EventHandler{
	 private BundleContext bundleContext;
	 private Logger log = LoggerFactory.getLogger(this.getClass());
	 @Reference
	 private ResourceResolverFactory rrf;
	 @Reference
		QueryBuilder queryBuilder;
	 private Resource resource;
	@SuppressWarnings("deprecation")
	@Override
	public void handleEvent(Event event) {
		String[] events = event.getPropertyNames();
		
		ReplicationAction action = ReplicationAction.fromEvent(event);
		String tag_ip = "stock/photo";
		
		if(action != null) {
			Session session = null ;
		
			 log.info("hello");
            log.info("Replication action {} occured on {} ", action.getType().getName(), action.getPath());
            ResourceResolver rr = null;
            
			try {
				
				rr = rrf.getAdministrativeResourceResolver(null);
				resource =	rr.getResource(action.getPath());
				SolrOperations sc= new SolrOperations();
		//	sc.addDocument(resource);
			sc.updateDocumentAndBoostingDocument();
				//GetDamAssets da = new GetDamAssets();
				//da.getAsset(rrf);
				//UploadingAsset ua =new UploadingAsset();
				
				//String x = ua.uploadingSingleAsset(rrf);
				//ua.uploadingMultipleAsset(rrf);
				session =rr.adaptTo(Session.class);
				 
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			log.info("rr!@#"+rr);
			resource =	rr.getResource(action.getPath());
			Node node= resource.adaptTo(Node.class);
			
				TagManager tgmr = rr.adaptTo(TagManager.class);
				
			Tag[] tago=	tgmr.getTags(resource);
		
			
			
			//tago is empty array
			Page page = resource.adaptTo(Page.class);
			
			
			
			Searching sr = new Searching();
			try {
				sr.searchMethod(session, queryBuilder);
			} catch (RepositoryException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ValueMap vmap2= page.getProperties();
			Date date=vmap2.get("cq:lastModified", Date.class);
			
			
		String[] d=	vmap2.get("cq:tags", new String[]{});
		
		for(String dd :d)
		{
			dd.equalsIgnoreCase(tag_ip);
		//iterate through dd and make condition where 2 strings have to be compared
			//if it matches, consolidate in array
			
		}
			List<Page> lp = new ArrayList<Page>();
			List<String> ls = new ArrayList<String>();
		if(page.getDepth()!=0)
		{
			Iterator<Page> ip =page.listChildren(null, true);
			while(ip.hasNext())
			{
				Page p =ip.next();
				String page_Name = p.getName();
				ls.add(page_Name);
				log.info("ls is::"+ls);
				
			}
		}
		
		
			int depth = page.getDepth();
			log.info("depth of pages"+depth);
			Tag[] tags = page.getTags();
			log.info("title of page"+page.getTitle());
			List<String> list_Of_strings = Arrays.asList(d);
			Iterator<String> it = list_Of_strings.iterator();
			List<Tag> ltag =new ArrayList<Tag>();
			while(it.hasNext())
			{
				String local_tag =it.next();
				Tag tag=tgmr.resolve(local_tag);
				ltag.add(tag);
				
				
			}
			for(Tag ltags : ltag)
			{
				String xx =ltags.getTagID();
			String z =ltags.getPath();
			String	xz=ltags.getLocalTagID();
			
				
			}
		
			
			/*tags has values fullname path of tags*/ 	
			
			
		
			//Tag[] atg =tag_manager.getTags(resource);
			 
			// 	int x =atg.length;
			
		//	String template =vmap.get("sling:resourceType", String.class);
			//vmap.put("cq:lastModifiedBy", "admins");
			try {
				session.save();
			} catch (AccessDeniedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ItemExistsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ReferentialIntegrityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ConstraintViolationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidItemStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (VersionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LockException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchNodeTypeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RepositoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//log.info("vp here is??"+"now what"+template);
			try {
				
				rr.commit();
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			/*
			
			log.info("true/false??"+vp.containsKey("cq:template"));
			log.info("true/false??"+vp.containsKey("jcr:createdBy"));
			vp.get("jcr:createdBy", ValueMap.class);
			log.info("treee444"+vp.get("jcr:createdBy", ValueMap.class));
			String admin = (String) vp.get("/jcr:createdBy");
			
		
			try {
			//
				String ds= rootnode.getProperty("cq:template").getString();
				log.info("dsss!@#"+ds);
			} catch (RepositoryException e2) {
				// TODO Auto-generated catch block
				log.error("The error here is"+e2.getMessage());
				e2.printStackTrace();
			}
			
			
			
			ModifiableValueMap mvp = resource.adaptTo(ModifiableValueMap.class);
			boolean s = mvp.containsKey("cq:template");
			Set<String> set = mvp.keySet();
			log.info("setto!@#"+set);
			for(String s1 : set)
			{
				log.info("s1 is::"+s1);
				
			}
			
			String user=  mvp.get("cq:lastModifiedBy", String.class);
			log.info("user!!!@#"+user);
			
			log.info("rscrs+++"+resource);
			log.info("admin guy$$"+admin);
			
			mvp.put("Kar", "123");
			
		
			try {
				rr.commit();
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
        }
	}
	protected void activate(ComponentContext ctx) {
        this.bundleContext = ctx.getBundleContext();
    }
     
    protected void deactivate(ComponentContext ctx) {
        this.bundleContext = null;
    }

	
	
}
