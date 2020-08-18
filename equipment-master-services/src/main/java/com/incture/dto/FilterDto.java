package com.incture.dto;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FilterDto extends BaseDto{

	private String id;
	private String category;
	private String status;
	private String validFrom;
	private String validTo;
	private String equipmentName;
	private String orderBy;
	private String sortBy;
	private String pageNo;
	private boolean type;
	private boolean processed;
	private boolean UpdatePending;
	
	private int t;
	
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public boolean isUpdatePending() {
		return UpdatePending;
	}
	public void setUpdatePending(boolean updatePending) {
		UpdatePending = updatePending;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String toString() {
		return "FilterDto [id=" + id + ", category=" + category + ", status=" + status + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", equipmentName=" + equipmentName + ", orderBy=" + orderBy + ", sortBy="
				+ sortBy + ", pageNo=" + pageNo + ", type=" + type + ", processed=" + processed + ", UpdatePending="
				+ UpdatePending + ", t=" + t + "]";
	}
	
	
	
}
