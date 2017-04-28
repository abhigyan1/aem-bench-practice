package com.example.core;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.HistoryItem;
import com.adobe.granite.workflow.exec.ParticipantStepChooser;
import com.adobe.granite.workflow.exec.Route;
import com.adobe.granite.workflow.exec.Status;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.Workflow;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.adobe.granite.workflow.model.WorkflowNode;
@Component(label="wFlow", description="what is this?")
@Service(value=WorkflowEx.class)
@Properties(
		{
			@org.apache.felix.scr.annotations.Property(name="service.description",
		value={"Sample Implementation of dynamic participant chooser."}),
		
		@org.apache.felix.scr.annotations.Property(name="chooser.label", 
		value={"Sample Workflow Participant Chooser"})})


public class WorkflowEx implements ParticipantStepChooser {
	@org.apache.felix.scr.annotations.Property( label="ass", cardinality=50, description="ass is ass baba")
	  private static final String MULTI_FIELD = "ass";
	@Override
	public String getParticipant(WorkItem arg0, WorkflowSession arg1,
			MetaDataMap arg2) throws WorkflowException {
		
		/*Finding out 3 parameters workitem, workflowsession , metadatamap*/
	
		// TODO Auto-generated method stub
		// Find what is workitem. What it contains and compare with use-case
		// What can be extracted from workitem
		
		
		/*conclusions: WorkItem Id: /etc/workflow/instances/server0/2017-04-18_2/dynamicparts_16/workItems/node1_etc_workflow_instances_server0_2017-04-18_2_dynamicparts_16
		Workflow Id: /etc/workflow/instances/server0/2017-04-18_2/dynamicparts_16
		Payload: /content/today/page17
		Payload Type: JCR_PATH
		key = historyEntryPath value = /etc/workflow/instances/server0/2017-04-18_2/dynamicparts_16/history/1492585800334
		key = absoluteTime value = 0
		key = comment value = comment for second step is over here*/
		
		String a = arg0.getCurrentAssignee();
		String b = arg0.getId();          
		String c = arg0.getItemType();
		
		//MetaDataMap m = arg0.getMetaDataMap(); not working for some reason
		Workflow wf = arg0.getWorkflow();
		/*{absoluteTime=2017-04-19T13:52:56.143+05:30, workflowTitle=Dyn parts, startComment=This is comment for modified workflow}
		 * Workflow comment: is the comment that was put by the 1st user
		 * Workitem comment: pertains to current step comment  
		 * */
	
		
	List<Route> routes = arg1.getRoutes(arg0, false);
		
		routes.size();
	Route z = routes.get(0);
	z.getId();
		
		
		
		
		// Find what is Workflowsession
		// How is different from Workitem
		// How to use
		
		/*//Workflow wff = arg1.getWorkflow("publish_example"); //get workflow     there are issues in fetching workflow
*/	//	Workflow wff1 = arg1.getWorkflow("Publish Example"); //get workflow     
		
		
		WorkflowData wfd = wf.getWorkflowData();  //getWorkflowData 
		if(arg1.getHistory(wf)!=null)
		{
		List<HistoryItem> wfHistory = arg1.getHistory(wf); //what are these historyitems list
		Node rsc = arg1.adaptTo(Node.class);
		HistoryItem hi = wfHistory.get(0); //what all data is available
		String comm = hi.getComment(); // why comm is empty
		String userID = hi.getUserId(); 
		Session session = arg1.adaptTo(Session.class);
		String whos_in_charge = session.getUserID();
		ResourceResolver rr= arg1.adaptTo(ResourceResolver.class);
		org.apache.sling.api.resource.Resource r =rr.resolve("/etc/workflow/instances/server0/2017-04-18_2/dynamicparts_20/history/1492594940155");
		Node node = r.adaptTo(Node.class);
		try {
			int t =node.getDepth();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		//arg1.createNewModel("prog"); //creating a new model
		/*WorkflowTransition wt =wm.createTransition(); //transitions between 2 workflow nodes
*/		
		WorkItem[]wii = arg1.getActiveWorkItems(); //current workflow's workitems list
		int zz= wii.length;
		//arg1.deployModel(wm);
		
		//Find what is metadatamap
		//why we need this parameter
		// what all parameters can be traced out of this
		
		MetaDataMap mpp =arg2; //What is metadata containing
		Set<String>sst = mpp.keySet();
		if(sst.isEmpty()==false)
		{
			for(String s : sst)
			{
				String g =s;
			}
		}
		int size = arg2.size();
		
		
		
		
		
		
		
		Set<String> sss =arg2.keySet();
		Iterator<String> is = sss.iterator();
		while(is.hasNext())
		{
		String v = 	is.next();
		}
		
		MetaDataMap mdm =wfd.getMetaDataMap();
		
		
		WorkflowNode d = arg0.getNode();
		MetaDataMap mppz = d.getMetaDataMap();
		String xx = arg2.get("PROCESS_ARGS", String.class);
		
		
		//Set<String> sets=arg2.keySet();
		String x = d.getDescription();
		Status i= arg0.getStatus();
		String f ="9";
		return "admin";
	}

}
