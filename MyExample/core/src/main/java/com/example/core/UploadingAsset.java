package com.example.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.api.metadata.ExtractedMetadata;
import com.day.cq.wcm.foundation.Download;

@Component
@Service(UploadingAsset.class)
public class UploadingAsset {
ResourceResolver rr;
	@SuppressWarnings("deprecation")
	public String uploadingSingleAsset(ResourceResolverFactory rrf) throws FileNotFoundException, LoginException
	
	{
	File file = new File("C://Users/acha71/Downloads/Pic.jpg");
	 InputStream targetStream = new FileInputStream(file);
	rr =rrf.getAdministrativeResourceResolver(null);
	
	 AssetManager am = rr.adaptTo(AssetManager.class);
	 Asset asset = am.createAsset("/content/dam/Pic.jpg", targetStream, "image/jpeg", true);
	 String asset_name = asset.getName();
	 
	 List<Rendition> ri =asset.getRenditions();
	for(Rendition r: ri)
	{
		ValueMap vmap = r.getValueMap();
		
	}
	return asset_name;
	}
	
	@SuppressWarnings("deprecation")
	public void uploadingMultipleAsset(ResourceResolverFactory rrf) throws LoginException
	
	{
		try{
		AssetManager am;
		File folder = new File("C://Users/acha71/Downloads/pics");
	    File[] listOfFiles = folder.listFiles(); 
	   for(File fl : listOfFiles)
	   {
		 
		   File xx =fl.getAbsoluteFile();
		  
			InputStream targetStream = new FileInputStream(xx);
			rr =rrf.getAdministrativeResourceResolver(null);
			
			if(   rr.adaptTo(AssetManager.class)!=null)
			{
				am= rr.adaptTo(AssetManager.class);
			 Asset asset = am.createAsset("/content/dam/"+xx, targetStream, "image/jpeg", true);
			
			 
			
			}
		} 
		   
		   
	   
	}
		catch(Exception ee)
		{
		String x =	ee.getMessage();
		}
		
		
		finally
			   {
			   rr.close();
			   
		   }
		}
	}


