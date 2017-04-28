package com.example.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

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
	public void readFileFromDisk(ResourceResolverFactory rrf) throws FileNotFoundException, LoginException
	{
	File file = new File("C://Users/acha71/Downloads/porcupine-tree.jpg");
	 InputStream targetStream = new FileInputStream(file);
	rr =rrf.getAdministrativeResourceResolver(null);
	
	 AssetManager am = rr.adaptTo(AssetManager.class);
	 Asset asset = am.createAsset("/content/dam/porcupine-tree.jpg", targetStream, "image/JPEG", true);
	
	
	}

}
