package com.example.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.facets.Bucket;
import com.day.cq.search.facets.Facet;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;

public class Searching {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void searchMethod(Session session, QueryBuilder queryBuilder) throws RepositoryException 
	{
		try{
		
		Map<String, String> hasmap = new HashMap<String, String>();
		hasmap.put("path", "/content/geometrixx-media");
		hasmap.put("type", "cq:page");
		hasmap.put("property", "jcr:title");
		hasmap.put("property.1_value", "circle");
		hasmap.put("property.2_value", "square");
		hasmap.put("property.3_value", "Triangle");
		/*hasmap.put("property.value", "admin");
		hasmap.put("daterange.property","cq:lastModified");
		hasmap.put("daterange.lowerBound","2017-11-30T11:56:04.985-05:00");
		hasmap.put("daterange.lowerOperation",">=");*/
		
		Query query = queryBuilder.createQuery(PredicateGroup.create(hasmap), session);
		
		query.setStart(0);
	    query.setHitsPerPage(20);
	    SearchResult result = query.getResult();
	   /* Map<String, Facet> fmap = new HashMap<String, Facet>();
	    fmap=   result.getFacets();
	    Facet s =fmap.get("property");
	    List<Bucket> lb =s.getBuckets();
	    
	    
	    
	    Set<String> sett = fmap.keySet();
	    for(String ss :sett)
	    {
	    	String c =ss+"ss";
	    	
	    }*/
	    
	    for(Hit hit : result.getHits())
	    {
	    	Resource rsc = hit.getResource();
	    	Node node =rsc.adaptTo(Node.class);
	    	
	    	String path = hit.getPath();
			log.info("path"+path);
			} 
		}
		catch(Exception exc)
		{
			String c =exc.getMessage();
			String z="c is"+c ;
		}
	    }
		
	}
	

