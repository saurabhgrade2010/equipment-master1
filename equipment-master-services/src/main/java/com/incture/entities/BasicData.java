package com.incture.entities;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "BASIC")
@Data
public class BasicData implements BaseData {

	
	
   

	@Id
	@EmbeddedId
	private EquipmentId equipmentId; 
	
	
	
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
	
	@Column(name="equipmentname")
	private String equipmentName;

	@Column(name="is_processed")
	private boolean is_processed; 
	 
		private static final long serialVersionUID = 1L;


		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
	public BasicData()
	{
		super();
	}


	public EquipmentId getEquipmentId() {
		return equipmentId;
	}


	public void setEquipmentId(EquipmentId equipmentId) {
		this.equipmentId = equipmentId;
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


	public boolean isIs_processed() {
		return is_processed;
	}


	public void setIs_processed(boolean is_processed) {
		this.is_processed = is_processed;
	}


	@Override
	public String toString() {
		return "BasicData [equipmentId=" + equipmentId + ", category=" + category + ", description=" + description
				+ ", status=" + status + ", validFrom=" + validFrom + ", validTo=" + validTo + ", equipmentName="
				+ equipmentName + ", is_processed=" + is_processed + "]";
	}


	public BasicData(EquipmentId equipmentId, String category, String description, String status, Date validFrom,
			Date validTo, String equipmentName, boolean is_processed) {
		super();
		this.equipmentId = equipmentId;
		this.category = category;
		this.description = description;
		this.status = status;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.equipmentName = equipmentName;
		this.is_processed = is_processed;
	}


	
	

	
	
	
}
