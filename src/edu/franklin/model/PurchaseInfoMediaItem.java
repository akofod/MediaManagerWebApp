package edu.franklin.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import edu.franklin.dataaccess.BaseORM;
import edu.franklin.dataaccess.Column;
import edu.franklin.dataaccess.KeyColumn;

public class PurchaseInfoMediaItem extends BaseORM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private double purPrice;
	private Date purDate;
	private int purInfoId;
	private int mediaItemId;
	
	public PurchaseInfoMediaItem(ResultSet rs) throws SQLException {
		this.id=rs.getInt("purchaseinfomediaitemid");
		this.purPrice=rs.getDouble("PurchasePrice");
		this.purInfoId=rs.getInt("PurchaseInfoID");
		this.mediaItemId=rs.getInt("PiiMediaItemId");
		this.purDate=rs.getDate("PurchaseDate");
	}
	public PurchaseInfoMediaItem() {}
	@KeyColumn(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="PurchasePrice")
	public double getPurPrice() {
		return purPrice;
	}
	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}
	
	@Column(name="PurchaseDate")
	public Date getPurDate() {
		return purDate;
	}
	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}
	
	@Column(name="PurchaseInfoID")
	public int getPurInfoId() {
		return purInfoId;
	}
	public void setPurInfoId(int purInfoId) {
		this.purInfoId = purInfoId;
	}
	
	@Column(name="MediaItemID")
	public int getMediaItemId() {
		return mediaItemId;
	}
	public void setMediaItemId(int mediaItemId) {
		this.mediaItemId = mediaItemId;
	}
	
	

}
