package com.incture.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "my_category")
@Data
public class MyCategory {
		
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "categoryid", columnDefinition = "NVARCHAR(36)")
	private String catgeoryId;
	
	@Column(name = "category_name" , columnDefinition = "NVARCHAR(50)")
	private String categoryName;

	public String getCatgeoryId() {
		return catgeoryId;
	}

	public void setCatgeoryId(String catgeoryId) {
		this.catgeoryId = catgeoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "MyCategory [catgeoryId=" + catgeoryId + ", categoryName=" + categoryName + "]";
	}

	public MyCategory(String catgeoryId, String categoryName) {
		super();
		this.catgeoryId = catgeoryId;
		this.categoryName = categoryName;
	}

	public MyCategory()
	{
		super();
	}

}
