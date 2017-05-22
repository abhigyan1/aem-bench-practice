package com.example.core.SolrExamples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
public class UpdateSolr implements Operations{

	

	@Override
	public void operationsOnSolr(Resource rsc) throws JSONException {



		final String urlString = "http://localhost:8983/solr/cricket";
		 SolrInputDocument sid1 = new SolrInputDocument();
		 SolrInputDocument sid2 = new SolrInputDocument();
		 SolrInputDocument sid3 = new SolrInputDocument();
		HttpSolrClient solrServer = new HttpSolrClient(urlString);
		
		try {
		SolrDocument sds =	solrServer.getById("001");
		
//		sds.addField("a new element", true);
		String value = sds.getFieldValue("id").toString();
		
		sid1.addField("id", "9" );
		sid1.addField("city", "LA",0.2f);
		
		sid2.addField("id", "22" );
		sid2.addField("city", "LA",0.7f);
		
		sid3.addField("id", "4" );
		sid3.addField("city", "LA",0.4f);
		List<SolrInputDocument> lss = new ArrayList<SolrInputDocument>();
		
		
		//StringField doesn't do anything special except have a customized fieldtype, so just use Field.
		
//		Field nameField = new Field("name", "", );
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


