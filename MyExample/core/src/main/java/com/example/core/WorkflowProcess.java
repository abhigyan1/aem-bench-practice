package com.example.core;

import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.solr.common.SolrDocument;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.*;
import com.adobe.granite.workflow.metadata.MetaDataMap;
@Component
@Service
@Properties
(
		{
			@Property(name="service.description",
					value={"Customized Process Step"}),
			@Property(name="chooser.label", 
					value={"Cutomized Workflow"})})

public class WorkflowProcess implements com.adobe.granite.workflow.exec.WorkflowProcess{

	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2)
			throws WorkflowException {
	
		String id = arg0.getId();
		
		ResourceResolver rr = arg1.adaptTo(ResourceResolver.class);
		Session sess = arg1.adaptTo(Session.class);
		MetaDataMap mp =arg2;
		String ar =  arg2.get("PROCESS_ARGS",String.class);
		
	
	}

}
