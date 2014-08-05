package edu.franklin.model;

import java.io.Serializable;

import edu.franklin.dataaccess.BaseORM;
import edu.franklin.dataaccess.Column;
import edu.franklin.dataaccess.KeyColumn;

public class PurchaseInfo extends BaseORM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id, itemCount;
	private String purLoc;

	@KeyColumn(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="PurchaseLocation")
	public String getPurLoc() {
		return purLoc;
	}

	public void setPurLoc(String purLoc) {
		this.purLoc = purLoc;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public boolean hasItems(){
		return this.itemCount>0;
	}

}
