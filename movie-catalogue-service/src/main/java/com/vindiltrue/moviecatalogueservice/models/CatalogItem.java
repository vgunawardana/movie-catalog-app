package com.vindiltrue.moviecatalogueservice.models;

public class CatalogItem {
	
	private String name;
	private String desc;
	private int ratings;
	
	public CatalogItem(String name,String desc, int ratings) {
		this.name = name;
		this.desc = desc;
		this.ratings = ratings;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
	
	

}
