package edu.franklin.model;

import java.io.Serializable;

public class ItemView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name, genre, mediaType, comments, purLoc, purDate;
	private int year;
	private double curValue, purPrice;

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getCurValue() {
		return curValue;
	}

	public void setCurValue(double curValue) {
		this.curValue = curValue;
	}

	public double getPurPrice() {
		return purPrice;
	}

	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}
	
	

}
