package com.example.core.listeners;



import java.util.Arrays;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true, metatype=true, label="get this up")
@Service(Observo.class)
public class Observo implements EventListener{
	private Logger log = LoggerFactory.getLogger(this.getClass());
    
    private BundleContext bundleContext;
    
     
    @Reference
    private SlingRepository repository;
     
  //Inject a Sling ResourceResolverFactory
    @Reference
    private ResourceResolverFactory resolverFactory;
     
    private Session session;
    private static final String CLASS_NAME = "[ConfigurationService]: ";
	  @Property( label="abc", cardinality=50, description="Example for Multi field config")
	  private static String MULTiI_FIELD = "abc";
	  @Property(unbounded=PropertyUnbounded.DEFAULT, label="pqr", description="Example for Simple text field config")
	  private static final String SIMPLE_FIELD = "pqr";
	  
	  @Property(unbounded=PropertyUnbounded.DEFAULT, label="trues", description="Examples for boolean values")
	  private static final String COMPLEX_FIELD = "trues";
    private ObservationManager observationManager;
     
    public void run() {
        log.info("Running...");
    }
    @Activate
    protected void activate(final Map<String, Object> config) {
       configure(config);
    }

    private void configure(final Map<String, Object> config) {
    	MULTiI_FIELD = PropertiesUtil.toString(config.get(MULTiI_FIELD), null);
        }
     
    //Place app logic here to define the AEM Custom Event Handler
    protected void activate(ComponentContext ctx) {
        this.bundleContext = ctx.getBundleContext();
         
        try
        {
                    
            //Invoke the adaptTo method to create a Session 
            // ResourceResolver resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
             session = repository.loginAdministrative(null);
              
            // Setup the event handler to respond to a new claim under content/claim.... 
                observationManager = session.getWorkspace().getObservationManager();
                 final String[] types = { "nt:unstructured","sling:Folder" };
                 final String path = "/content/ea/help"; // define the path
                 observationManager.addEventListener(this, Event.NODE_ADDED, path, true, null, null, false);
                 log.info("1234e"+path+"sss");
                 log.info("Observing property changes to {} nodes under {}", Arrays.asList(types));
                           
         }
        catch(Exception e)
        {
            e.printStackTrace(); 
         }
        }
 
         protected void deactivate(ComponentContext componentContext) throws RepositoryException {
              
             if(observationManager != null) {
                 observationManager.removeEventListener(this);
             }
             if (session != null) {
                 session.logout();
                 session = null;
               }
         }
 
        //Define app logic that is fired when the event occurs - simply track the time 
        //when the event occurred. 
         public void onEvent(EventIterator itr) {
              
             //Calendar cal = Calendar.getInstance();
            //cal.getTime();
            //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
              
            //log the time when the event occurred 
             log.info("A new node was added to content/claim ");
                          
         }
}