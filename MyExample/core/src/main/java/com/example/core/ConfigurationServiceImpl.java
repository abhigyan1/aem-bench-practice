package com.example.core;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



	@Service({ConfigurationServiceImpl.class})
	@Component(immediate=true, metatype=true, label="Example Configuration Service")
	public class ConfigurationServiceImpl
	  
	{
	  //private static final Logger LOG = LoggerFactory.getLogger(ConfigurationServiceImpl.class);
	  private static final String CLASS_NAME = "[ConfigurationService]: ";
	  @Property( label="abc", cardinality=50, description="Example for Multi field config")
	  private static final String MULTI_FIELD = "abc";
	  @Property(unbounded=PropertyUnbounded.DEFAULT, label="pqr", description="Example for Simple text field config")
	  private static final String SIMPLE_FIELD = "pqr";
	  
	  @Property(unbounded=PropertyUnbounded.DEFAULT, label="trues", description="Examples for boolean values")
	  private static final String COMPLEX_FIELD = "trues";
	  
	  private String multiString;
	  private String simpleString;
	  private boolean trues ;
	   
	  public String getMultiString()
	  {
	    return this.multiString;
	  }
	   
	  public String getSimpleString()
	  {
	    return this.simpleString;
	  }
	   
	  public boolean isTrues() {
		return this.trues;
	}
	

	@Activate
	  protected void activate(Map<String, Object> properties)
	  {
	   // LOG.info("[*** AEM ConfigurationService]: activating configuration service");
	    readProperties(properties);
	  }
	   
	  protected void readProperties(Map<String, Object> properties)
	  {
	    //LOG.info(properties.toString());
	    this.multiString = PropertiesUtil.toString(properties.get("abc"), "default");
	   
	    this.simpleString = PropertiesUtil.toString(properties.get("pqr"), "default");
	    
	    this.trues = PropertiesUtil.toBoolean(trues, true);
	    //LOG.info("Simple String: " + this.simpleString);
	  }
	}
