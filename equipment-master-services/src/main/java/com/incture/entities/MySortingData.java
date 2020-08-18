package com.incture.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "my_sorting")
@Data
public class MySortingData {
	
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "sortid", columnDefinition = "NVARCHAR(36)")
	private String sortId;
	
	@Column(name = "sort_name" , columnDefinition = "NVARCHAR(50)")
	private String sortName;

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	@Override
	public String toString() {
		return "MySortingData [sortId=" + sortId + ", sortName=" + sortName + "]";
	}

	public MySortingData(String sortId, String sortName) {
		super();
		this.sortId = sortId;
		this.sortName = sortName;
	}
	
	public MySortingData()
	{
		super();
	}


}
