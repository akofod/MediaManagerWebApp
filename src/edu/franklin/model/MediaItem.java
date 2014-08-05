package edu.franklin.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.franklin.dataaccess.BaseORM;
import edu.franklin.dataaccess.Column;
import edu.franklin.dataaccess.KeyColumn;

public class MediaItem extends BaseORM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int genreId;
	private int mediaTypeId;
	private String name;
	private int year;
	private String comments;
	private double curVal;
	private PurchaseInfoMediaItem purInfo;
	
	public MediaItem() {}
	
	public MediaItem(ResultSet rs) throws SQLException {
		id = rs.getInt("ID");
		genreId = rs.getInt("genreid");
		mediaTypeId = rs.getInt("mediatypeid");
		name = rs.getString("name");
		year = rs.getInt("year");
		comments = rs.getString("comments");
		curVal = rs.getDouble("CurrentValue");
	}

	@KeyColumn(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="GenreId")
	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	@Column(name="MediaTypeId")
	public int getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	@Column(name="Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="Year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name="Comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name="CurrentValue")
	public double getCurVal() {
		return curVal;
	}

	public void setCurVal(double curVal) {
		this.curVal = curVal;
	}
	
	public void setPurInfo(PurchaseInfoMediaItem purInfo) {
		this.purInfo = purInfo;
	}
	
	public PurchaseInfoMediaItem getPurInfo() {
		return purInfo;
	}

}
