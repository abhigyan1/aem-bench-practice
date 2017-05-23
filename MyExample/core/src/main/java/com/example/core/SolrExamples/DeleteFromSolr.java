package com.example.core.SolrExamples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class DeleteFromSolr implements Operations{

	@Override
	public void operationsOnSolr(Resource rsc) throws JSONException,
			SolrServerException, IOException {
		final String urlString = "http://localhost:8983/solr/cricket";
		HttpSolrClient solrServer = new HttpSolrClient(urlString);
		List<String> list_ids = new ArrayList<String>();
		list_ids.add("001");
		list_ids.add("002");
		list_ids.add("003");
		list_ids.add("004");
		list_ids.add("005");
		list_ids.add("006");
		solrServer.deleteById(list_ids);
		solrServer.commit();
		solrServer.close();
		
	}

}
