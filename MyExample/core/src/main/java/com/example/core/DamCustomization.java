package com.example.core;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.metadata.ExtractedMetadata;
import com.day.cq.dam.commons.handler.AbstractAssetHandler;
import com.day.cq.dam.core.AbstractAssetProcess;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;


public class DamCustomization extends AbstractAssetHandler {

	@Override
	public ExtractedMetadata extractMetadata(Asset paramAsset) {
		// TODO Auto-generated method stub
		paramAsset.getRenditions();
		return null;
	}

	@Override
	public String[] getMimeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
