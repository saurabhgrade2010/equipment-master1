package com.incture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationDto extends BaseDto{

	
	private String id;
	private int version;
	private String maintenancePlant;
	private String location;
	private String room;
	private String plantSection;
	private String abcIndicator;
	private String sortField;
	private String workCenter;
	private String name;
	private String street;
	private String fax;
	private String telephone;
	
	public LocationDto()
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

	public String getMaintenancePlant() {
		return maintenancePlant;
	}

	public void setMaintenancePlant(String maintenancePlant) {
		this.maintenancePlant = maintenancePlant;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getPlantSection() {
		return plantSection;
	}

	public void setPlantSection(String plantSection) {
		this.plantSection = plantSection;
	}

	public String getAbcIndicator() {
		return abcIndicator;
	}

	public void setAbcIndicator(String abcIndicator) {
		this.abcIndicator = abcIndicator;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getWorkCenter() {
		return workCenter;
	}

	public void setWorkCenter(String workCenter) {
		this.workCenter = workCenter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "LocationDto [id=" + id + ", version=" + version + ", maintenancePlant=" + maintenancePlant
				+ ", location=" + location + ", room=" + room + ", plantSection=" + plantSection + ", abcIndicator="
				+ abcIndicator + ", sortField=" + sortField + ", workCenter=" + workCenter + ", name=" + name
				+ ", street=" + street + ", fax=" + fax + ", telephone=" + telephone + "]";
	}

	
	
	
}
