package com.artShop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyArts")
public class MyArtList {
	
	@Id
	private int id;
	private String name;
	private String artist;
	private String price;
	
	public MyArtList(int id, String name, String artist, String price) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.price = price;
	}

	public MyArtList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
