package com.incture.dto;

import java.util.List;

public class AllDto {
	
	private BasicDTO basicDetails;
	private GeneralDto generalDetails;
	private List<LocationDto> locationList;
	private List<OrganizationDto> organizationList;
	public BasicDTO getBasicDetails() {
		return basicDetails;
	}
	public void setBasicDetails(BasicDTO basicDetails) {
		this.basicDetails = basicDetails;
	}
	public GeneralDto getGeneralDetails() {
		return generalDetails;
	}
	public void setGeneralDetails(GeneralDto generalDetails) {
		this.generalDetails = generalDetails;
	}
	public List<LocationDto> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<LocationDto> locationList) {
		this.locationList = locationList;
	}
	public List<OrganizationDto> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(List<OrganizationDto> organizationList) {
		this.organizationList = organizationList;
	}
	@Override
	public String toString() {
		return "AllDto [basicDetails=" + basicDetails + ", generalDetails=" + generalDetails + ", locationList="
				+ locationList + ", organizationList=" + organizationList + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
