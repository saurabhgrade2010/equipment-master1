package com.incture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrganizationDto extends BaseDto{

	private String id;
	private int version;
	private String companyCode;
	private String asset;
	private String costArea;
	private String maintenancePlanningCenter;

	private String plannerGroup;
	private String mainWorkCenter;
	private String catalogProfile;
	private String businessArea;
	private String manufacturerSerialNo;
	private String currencyKey;
	private String plantAssociated;

	public OrganizationDto()
	{
		super();
	}

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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getCostArea() {
		return costArea;
	}

	public void setCostArea(String costArea) {
		this.costArea = costArea;
	}

	public String getMaintenancePlanningCenter() {
		return maintenancePlanningCenter;
	}

	public void setMaintenancePlanningCenter(String maintenancePlanningCenter) {
		this.maintenancePlanningCenter = maintenancePlanningCenter;
	}

	public String getPlannerGroup() {
		return plannerGroup;
	}

	public void setPlannerGroup(String plannerGroup) {
		this.plannerGroup = plannerGroup;
	}

	public String getMainWorkCenter() {
		return mainWorkCenter;
	}

	public void setMainWorkCenter(String mainWorkCenter) {
		this.mainWorkCenter = mainWorkCenter;
	}

	public String getCatalogProfile() {
		return catalogProfile;
	}

	public void setCatalogProfile(String catalogProfile) {
		this.catalogProfile = catalogProfile;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getManufacturerSerialNo() {
		return manufacturerSerialNo;
	}

	public void setManufacturerSerialNo(String manufacturerSerialNo) {
		this.manufacturerSerialNo = manufacturerSerialNo;
	}

	public String getCurrencyKey() {
		return currencyKey;
	}

	public void setCurrencyKey(String currencyKey) {
		this.currencyKey = currencyKey;
	}

	public String getPlantAssociated() {
		return plantAssociated;
	}

	public void setPlantAssociated(String plantAssociated) {
		this.plantAssociated = plantAssociated;
	}

	@Override
	public String toString() {
		return "OrganizationDto [id=" + id + ", version=" + version + ", companyCode=" + companyCode + ", asset="
				+ asset + ", costArea=" + costArea + ", maintenancePlanningCenter=" + maintenancePlanningCenter
				+ ", plannerGroup=" + plannerGroup + ", mainWorkCenter=" + mainWorkCenter + ", catalogProfile="
				+ catalogProfile + ", businessArea=" + businessArea + ", manufacturerSerialNo=" + manufacturerSerialNo
				+ ", currencyKey=" + currencyKey + ", plantAssociated=" + plantAssociated + "]";
	}
	
	
	
	
}
