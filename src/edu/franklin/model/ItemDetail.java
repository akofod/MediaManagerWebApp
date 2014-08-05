package edu.franklin.model;

import java.io.Serializable;

public class ItemDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String genre;
	private String mediaType;
	private int year;
	private String comments;
	private double curVal;
	private String purLoc;
	private String purDate;
	private double purPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getCurVal() {
		return curVal;
	}
	public void setCurVal(double curVal) {
		this.curVal = curVal;
	}
	public String getPurLoc() {
		return purLoc;
	}
	public void setPurLoc(String purLoc) {
		this.purLoc = purLoc;
	}
	public String getPurDate() {
		return purDate;
	}
	public void setPurDate(String purDate) {
		this.purDate = purDate;
	}
	public double getPurPrice() {
		return purPrice;
	}
	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}
	
	
}
