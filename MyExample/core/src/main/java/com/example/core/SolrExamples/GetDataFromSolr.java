package com.example.core.SolrExamples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

public class GetDataFromSolr implements Operations {
public static void main(String[] args) throws JSONException, SolrServerException, IOException{
	GetDataFromSolr gd= new GetDataFromSolr();
	Resource rsc = null;
gd.operationsOnSolr(rsc);
}
	@Override
	public void operationsOnSolr(Resource rsc) throws JSONException, SolrServerException, IOException {
		final String urlString = "http://localhost:8983/solr/cricket";
		HttpSolrClient solrServer = new HttpSolrClient(urlString);
		SolrDocument sds =	solrServer.getById("33");
		Map<String, Collection<Object>> map = sds.getFieldValuesMap();
		
	
		solrServer.addBean( new Docs("56", "DC") );
		solrServer.addBean( new Docs("58", "Mum") );
		
		solrServer.commit();
	}

}
