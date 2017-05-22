package com.example.core.SolrExamples;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.json.jcr.JsonItemWriter;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;


public class AddingDocumentsSolr implements Operations{
	
	
	@Override
	public void operationsOnSolr(Resource resource) throws JSONException {



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
		 try {
			jsonWriter.dump(node, stringWriter, -1, true);
		} catch (RepositoryException | JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
}
