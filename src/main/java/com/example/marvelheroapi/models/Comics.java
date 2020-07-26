package com.example.marvelheroapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comics {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int comicReference;
	private String comicName;
	private String resourceUri;
	private String detail;
	private int pageCount;
	
	public int getComicReference() {
		return comicReference;
	}
	public void setComicReference(int comicReference) {
		this.comicReference = comicReference;
	}
	
	public String getComicName() {
		return comicName;
	}
	
	public void setComicName(String comicName) {
		this.comicName = comicName;
	}
	
	public String getResourceUri() {
		return resourceUri;
	}
	
	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

}
