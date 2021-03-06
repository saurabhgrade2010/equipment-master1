package com.incture.dto;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class BasicDTO extends BaseDto{
	
	private String id;
	private int version;
	private String category;
	private String description;
	private String status;
	private String validFrom;
	private String validTo;
	private String equipmentName;
	private boolean is_processed;
	private boolean isUpdatePendiing;
	private String pageNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
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
	public boolean isUpdatePendiing() {
		return isUpdatePendiing;
	}
	public void setUpdatePendiing(boolean isUpdatePendiing) {
		this.isUpdatePendiing = isUpdatePendiing;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String toString() {
		return "BasicDTO [id=" + id + ", version=" + version + ", category=" + category + ", description=" + description
				+ ", validFrom=" + validFrom + ", validTo=" + validTo + ", equipmentName=" + equipmentName
				+ ", is_processed=" + is_processed + "]";
	}
	
	
	

	

}
