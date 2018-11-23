package com.example.loic.comics_app_android.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Comic{

	@SerializedName("code")
	private int code;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Comic{" + 
			"code = '" + code + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}