package com.incture.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name="organization_master")
@Data
public class OrganizationDataMaster implements  BaseData {

	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "organizationid", columnDefinition = "NVARCHAR(36)")
	private String organizationId;

	
	@ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BasicDataMaster id;
	
	@Column(name="companycode" , columnDefinition = "NVARCHAR(50)")
	private String companyCode;
	
	@Column(name="asset" , columnDefinition = "NVARCHAR(50)")
	private String asset;
	
	@Column(name="costarea" , columnDefinition = "NVARCHAR(50)")
	private String costArea;
	
	@Column(name="businessarea" , columnDefinition = "NVARCHAR(50)")
	private String businessArea;
	
	@Column(name="plannergroup" , columnDefinition = "NVARCHAR(50)")
	private String plannerGroup;
	
	@Column(name="maintenancePlanningCenter" , columnDefinition = "NVARCHAR(50)")
	private String maintenancePlanningCenter;
	
	@Column(name="catalogprofile" , columnDefinition = "NVARCHAR(50)")
	private String catalogProfile;
	
	@Column(name="currencykey" , columnDefinition = "NVARCHAR(50)")
	private String currencyKey;
	
	@Column(name="mainworkcenter" , columnDefinition = "NVARCHAR(50)")
	private String mainWorkCenter;
	
	@Column(name="plantassociated" , columnDefinition = "NVARCHAR(50)")
	private String plantAssociated;
	
	@Column(name="manufacturerSerialNo" , columnDefinition = "NVARCHAR(50)")
	private String manufacturerSerialNo;
	
	public OrganizationDataMaster()
	{
		super();
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public BasicDataMaster getId() {
		return id;
	}

	public void setId(BasicDataMaster id) {
		this.id = id;
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

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getPlannerGroup() {
		return plannerGroup;
	}

	public void setPlannerGroup(String plannerGroup) {
		this.plannerGroup = plannerGroup;
	}

	public String getMaintenancePlanningCenter() {
		return maintenancePlanningCenter;
	}

	public void setMaintenancePlanningCenter(String maintenancePlanningCenter) {
		this.maintenancePlanningCenter = maintenancePlanningCenter;
	}

	public String getCatalogProfile() {
		return catalogProfile;
	}

	public void setCatalogProfile(String catalogProfile) {
		this.catalogProfile = catalogProfile;
	}

	public String getCurrencyKey() {
		return currencyKey;
	}

	public void setCurrencyKey(String currencyKey) {
		this.currencyKey = currencyKey;
	}

	public String getMainWorkCenter() {
		return mainWorkCenter;
	}

	public void setMainWorkCenter(String mainWorkCenter) {
		this.mainWorkCenter = mainWorkCenter;
	}

	public String getPlantAssociated() {
		return plantAssociated;
	}

	public void setPlantAssociated(String plantAssociated) {
		this.plantAssociated = plantAssociated;
	}

	public String getManufacturerSerialNo() {
		return manufacturerSerialNo;
	}

	public void setManufacturerSerialNo(String manufacturerSerialNo) {
		this.manufacturerSerialNo = manufacturerSerialNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrganizationDataMaster [organizationId=" + organizationId + ", id=" + id + ", companyCode="
				+ companyCode + ", asset=" + asset + ", costArea=" + costArea + ", businessArea=" + businessArea
				+ ", plannerGroup=" + plannerGroup + ", maintenancePlanningCenter=" + maintenancePlanningCenter
				+ ", catalogProfile=" + catalogProfile + ", currencyKey=" + currencyKey + ", mainWorkCenter="
				+ mainWorkCenter + ", plantAssociated=" + plantAssociated + ", manufacturerSerialNo="
				+ manufacturerSerialNo + "]";
	}

	public OrganizationDataMaster(String organizationId, BasicDataMaster id, String companyCode, String asset,
			String costArea, String businessArea, String plannerGroup, String maintenancePlanningCenter,
			String catalogProfile, String currencyKey, String mainWorkCenter, String plantAssociated,
			String manufacturerSerialNo) {
		super();
		this.organizationId = organizationId;
		this.id = id;
		this.companyCode = companyCode;
		this.asset = asset;
		this.costArea = costArea;
		this.businessArea = businessArea;
		this.plannerGroup = plannerGroup;
		this.maintenancePlanningCenter = maintenancePlanningCenter;
		this.catalogProfile = catalogProfile;
		this.currencyKey = currencyKey;
		this.mainWorkCenter = mainWorkCenter;
		this.plantAssociated = plantAssociated;
		this.manufacturerSerialNo = manufacturerSerialNo;
	}

	
	

	
	
	
	
	
}
