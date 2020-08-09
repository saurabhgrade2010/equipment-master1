package com.incture.entities;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "BASIC_MASTER")
@Data
public class BasicDataMaster implements BaseData  {

	
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Id
	@Column(name = "id", columnDefinition = "NVARCHAR(36)")
	private String id;
	
	@Column(name = "category" , columnDefinition = "NVARCHAR(50)")
	private String category;
	
	@Column(name = "description" , columnDefinition = "NVARCHAR(100)")
	private String description;
	
	@Column(name = "status" , columnDefinition = "NVARCHAR(30)")
	private String status;
	
	@Column(name = "validFrom")
	private Date validFrom;
	
	@Column(name = "validTo")
	private Date validTo;
	
	@Column(name="equipmentname" , columnDefinition = "NVARCHAR(50)")
	private String equipmentName;

	@Column(name="isUpdatePending")
	private boolean isUpdatePending; 
	
	public BasicDataMaster(String id, String category, String description, String status, Date validFrom, Date validTo,
			String equipmentName, boolean isUpdatePending) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
		this.status = status;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.equipmentName = equipmentName;
		this.isUpdatePending = isUpdatePending;
	}

	@Override
	public String toString() {
		return "BasicDataMaster [id=" + id + ", category=" + category + ", description=" + description + ", status="
				+ status + ", validFrom=" + validFrom + ", validTo=" + validTo + ", equipmentName=" + equipmentName
				+ ", isUpdatePending=" + isUpdatePending + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public boolean isUpdatePending() {
		return isUpdatePending;
	}

	public void setUpdatePending(boolean isUpdatePending) {
		this.isUpdatePending = isUpdatePending;
	}

	public BasicDataMaster()
	{
		super();
	}

	
	
	
	
	
}
