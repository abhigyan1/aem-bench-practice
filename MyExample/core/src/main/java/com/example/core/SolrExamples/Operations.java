package com.example.core.SolrExamples;

import java.io.IOException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.solr.client.solrj.SolrServerException;



public interface Operations {

public void operationsOnSolr(Resource rsc) throws JSONException, SolrServerException, IOException;
}

