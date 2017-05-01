package com.example.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.dam.api.Rendition;

@Component
@Service(UploadingAsset.class)
public class UploadingAsset {
ResourceResolver rr;
	@SuppressWarnings("deprecation")
	public void uploadingSingleAsset(ResourceResolverFactory rrf) throws FileNotFoundException, LoginException
	
	{
	File file = new File("C://Users/acha71/Downloads/porcupine-tree.jpg");
	 InputStream targetStream = new FileInputStream(file);
	rr =rrf.getAdministrativeResourceResolver(null);
	
	 AssetManager am = rr.adaptTo(AssetManager.class);
	 Asset asset = am.createAsset("/content/dam/porcupine-tree.jpg", targetStream, "image/JPEG", true);
	 
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
		   String x = fl.getName();
		   File xx =fl.getAbsoluteFile();
			InputStream targetStream = new FileInputStream(xx);
			rr =rrf.getAdministrativeResourceResolver(null);
			
			if(   rr.adaptTo(AssetManager.class)!=null)
			{
				am= rr.adaptTo(AssetManager.class);
			 Asset asset = am.createAsset("/content/dam/"+x, targetStream, "image/JPEG", true);
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


