package com.example.loic.comics_app_android.data.model;

import com.google.gson.annotations.SerializedName;

public class CreatorsItem{

	@SerializedName("role")
	private String role;

	@SerializedName("name")
	private String name;

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"CreatorsItem{" + 
			"role = '" + role + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}