package com.example.core.SolrExamples;

import java.io.IOException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.solr.client.solrj.SolrServerException;

public class SolrFactoryClass  {
	
Operations add = new AddingDocumentsSolr();
Operations update = new UpdateSolr();
Operations get = new GetDataFromSolr();
Operations del = new DeleteFromSolr();


public  SolrFactoryClass(String type, Resource rsc) throws JSONException, SolrServerException, IOException
{
	if(type.equalsIgnoreCase("add"))
	{
		add.operationsOnSolr(rsc);
	}
	if(type.equalsIgnoreCase("update"))
	{
		update.operationsOnSolr(rsc);
	}
	if(type.equalsIgnoreCase("get"))
	{
		get.operationsOnSolr(rsc);
	}
	if(type.equalsIgnoreCase("del"))
	{
		del.operationsOnSolr(rsc);
	}
}

}
