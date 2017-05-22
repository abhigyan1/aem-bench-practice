package com.example.core;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.lucene.document.StringField;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.json.jcr.JsonItemWriter;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.schema.SchemaRequest;
import org.apache.solr.client.solrj.request.schema.SchemaRequest.AddField;
import org.apache.solr.client.solrj.request.schema.SchemaRequest.Field;
import org.apache.solr.client.solrj.request.schema.SchemaRequest.FieldType;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.client.solrj.response.schema.SchemaResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
@Component
@Service(SolrOperations.class)
public class SolrOperations {
	
	public void addDocument(Resource resource) throws RepositoryException, JSONException
	//public static void main(String[] argsv)
	 {
		 final String urlString = "http://localhost:8983/solr/cricket";
		 
		HttpSolrClient solrServer = new HttpSolrClient(urlString);
		
		 SolrInputDocument doc = new SolrInputDocument();
		 //Get some content from AEM and kickass by converting data into json
		 Node node =resource.adaptTo(Node.class);
		 StringWriter stringWriter = new StringWriter();
		 Set<String> set= new HashSet<String>();
		 set.add("jcr:content");
		 set.add("jcr:primaryType");
		 set.add("jcr:versionHistory");
		 set.add("jcr:predecessors");
		 set.add("jcr:baseVersion");
		 set.add("jcr:uuid");
		 
		 JsonItemWriter jsonWriter = new JsonItemWriter(set);
		 jsonWriter.dump(node, stringWriter, -1, true);
		 String json = stringWriter.toString();
		 JSONObject jo =new JSONObject(json);
		 
		  doc.addField("jcr:created", jo.get("jcr:created"));
		  doc.addField("jcr:createdBy", jo.get("jcr:createdBy"));
		  
		  try {
		   solrServer.add(doc);
		   solrServer.commit();
		  } catch (SolrServerException e) {
		  System.out.println( e.getMessage());
		  } catch (IOException e) {
			  System.out.println( e.getMessage());
		  }
		  finally{
			  System.out.println("All done");
			  try {
				solrServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		  }
	 }
	/*update this document*/
	
	
	public void updateDocumentAndBoostingDocument()
	{
		final String urlString = "http://localhost:8983/solr/cricket";
		 SolrInputDocument sid1 = new SolrInputDocument();
		 SolrInputDocument sid2 = new SolrInputDocument();
		 SolrInputDocument sid3 = new SolrInputDocument();
		HttpSolrClient solrServer = new HttpSolrClient(urlString);
		
		try {
		SolrDocument sds =	solrServer.getById("001");
		
	//	sds.addField("a new element", true);
		String value = sds.getFieldValue("id").toString();
		
		sid1.addField("id", "9" );
		sid1.addField("city", "LA",0.2f);
		
		sid2.addField("id", "22" );
		sid2.addField("city", "LA",0.7f);
		
		sid3.addField("id", "4" );
		sid3.addField("city", "LA",0.4f);
		List<SolrInputDocument> lss = new ArrayList<SolrInputDocument>();
		
		
		//StringField doesn't do anything special except have a customized fieldtype, so just use Field.
		
	//	Field nameField = new Field("name", "", );
		lss.add(sid1);
		lss.add(sid2);
		lss.add(sid3);
	Collection<SolrInputDocument> c = lss;

		solrServer.add(c);
//		solrServer.add(sid1);
		
		solrServer.commit();
		
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			String msg = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			String msg = e.getMessage();
		}
		finally
		{
			try {
				solrServer.close();
				System.out.println("Things worked fine");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
		}
	}
		 }

