package edu.franklin.model;

import java.io.Serializable;

import edu.franklin.dataaccess.BaseORM;
import edu.franklin.dataaccess.Column;
import edu.franklin.dataaccess.KeyColumn;

public class MediaType extends BaseORM implements Serializable{
	static final long serialVersionUID = 1L;
	
	private int id;
	private String mediaType;
	private int itemCount;
	
	@KeyColumn(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="MediaTypeDescription")
	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
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
