package com.example.loic.comics_app_android.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("date")
	private String date;

	@SerializedName("image")
	private String image;

	@SerializedName("pageCount")
	private int pageCount;

	@SerializedName("variantDescription")
	private String variantDescription;

	@SerializedName("digitalId")
	private int digitalId;

	@SerializedName("price")
	private double price;

	@SerializedName("creators")
	private List<CreatorsItem> creators;

	@SerializedName("issueNumber")
	private int issueNumber;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("diamondCode")
	private String diamondCode;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	public int getPageCount(){
		return pageCount;
	}

	public void setVariantDescription(String variantDescription){
		this.variantDescription = variantDescription;
	}

	public String getVariantDescription(){
		return variantDescription;
	}

	public void setDigitalId(int digitalId){
		this.digitalId = digitalId;
	}

	public int getDigitalId(){
		return digitalId;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setCreators(List<CreatorsItem> creators){
		this.creators = creators;
	}

	public List<CreatorsItem> getCreators(){
		return creators;
	}

	public void setIssueNumber(int issueNumber){
		this.issueNumber = issueNumber;
	}

	public int getIssueNumber(){
		return issueNumber;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDiamondCode(String diamondCode){
		this.diamondCode = diamondCode;
	}

	public String getDiamondCode(){
		return diamondCode;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"date = '" + date + '\'' + 
			",image = '" + image + '\'' + 
			",pageCount = '" + pageCount + '\'' + 
			",variantDescription = '" + variantDescription + '\'' + 
			",digitalId = '" + digitalId + '\'' + 
			",price = '" + price + '\'' + 
			",creators = '" + creators + '\'' + 
			",issueNumber = '" + issueNumber + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",diamondCode = '" + diamondCode + '\'' + 
			"}";
		}
}