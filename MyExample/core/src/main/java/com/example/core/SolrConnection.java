package com.example.core;

import java.io.IOException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
@Component
@Service(SolrConnection.class)
public class SolrConnection {
	
	public void addDocument()
	//public static void main(String[] argsv)
	 {
		 final String urlString = "http://localhost:8983/solr/InternalDoc/";
		 
		HttpSolrClient solrServer = new HttpSolrClient(urlString);
		
		 SolrInputDocument doc = new SolrInputDocument();
		 
		  doc.addField("id", "opop");
		  
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

