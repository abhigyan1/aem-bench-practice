package com.example.core.SolrExamples;

import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

public class Docs extends SolrDocument{

@Field("city")
private String city;
@Field("id")
private String id;
public String getCity() {
	return city;
}@Field("city")
public void setCity(String city) {
	this.city = city;
}
public String getId() {
	return id;
}
@Field("id")
public void setId(String id) {
	this.id = id;
}
public Docs(String id, String city) {
	this.id = id;
	this.city = city;
	// TODO Auto-generated constructor stub
}

}
