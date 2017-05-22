package com.example.core.SolrExamples;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;

public class SolrFactoryClass  {
	
Operations add = new AddingDocumentsSolr();
Operations update = new UpdateSolr();

public SolrFactoryClass() {};

public  SolrFactoryClass(String type, Resource rsc) throws JSONException
{
	if(type.equalsIgnoreCase("add"))
	{
		add.operationsOnSolr(rsc);
	}
	if(type.equalsIgnoreCase("update"))
	{
		update.operationsOnSolr(rsc);
	}
}

}
