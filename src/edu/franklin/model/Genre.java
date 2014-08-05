package edu.franklin.model;

import java.io.Serializable;

import edu.franklin.dataaccess.BaseORM;
import edu.franklin.dataaccess.Column;
import edu.franklin.dataaccess.KeyColumn;

public class Genre extends BaseORM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String genreDesc;
	private int itemCount;

	@KeyColumn(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="GenreDescription")
	public String getGenreDesc() {
		return genreDesc;
	}

	public void setGenreDesc(String genreDesc) {
		this.genreDesc = genreDesc;
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
