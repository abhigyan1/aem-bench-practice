package com.example.core;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;

import com.adobe.granite.asset.api.AssetRelation;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetHandlerException;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.api.handler.AssetHandler;
import com.day.cq.dam.api.metadata.ExtractedMetadata;
import com.day.cq.dam.api.thumbnail.ThumbnailConfig;







@Component
@Service(GetDamAssets.class)

public class GetDamAssets  {
	ResourceResolver rsc;
	Session session;
public void getAsset(ResourceResolverFactory rrf) throws LoginException, PathNotFoundException, RepositoryException
{
	rsc = rrf.getAdministrativeResourceResolver(null);
//	AssetManager amanager = rsc.adaptTo(AssetManager.class);
	
	Resource rs =  rsc.getResource("/content/dam/wilson.jpg");
	Asset asset = rs.adaptTo(Asset.class);
	Node node = asset.adaptTo(Node.class);
	Value v =node.getProperty("jcr:created").getValue();
	String gg =v.getString();
	//String name = user.getName();

	String x = asset.getMetadataValue("dam:Progressive");
	asset.getMetadataValue("");
	Long z = asset.getLastModified();	
	
	//Image image = null;
    
    	
   
  
   
  
    	}

    	
    	
    	
   // 	image = ImageIO.read(sourceimage);
    
}
