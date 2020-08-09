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
@Table(name="location_master")
@Data
public class LocationDataMaster implements BaseData  {


	
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "locationid", columnDefinition = "NVARCHAR(36)")
	private String locationId;
	
	@ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BasicDataMaster id;
	
	@Column(name="maintenanceplant" , columnDefinition = "NVARCHAR(50)")
	private String maintenancePlant;
	
	@Column(name="location" , columnDefinition = "NVARCHAR(50)")
	private String location;
	
	@Column(name="room" , columnDefinition = "NVARCHAR(50)")
	private String room;
	
	@Column(name="name" , columnDefinition = "NVARCHAR(50)")
	private String name;
	
	@Column(name="fax" , columnDefinition = "NVARCHAR(50)")
	private String fax;
	
	@Column(name="street" , columnDefinition = "NVARCHAR(50)")
	private String street;
	
	@Column(name="telephone" , columnDefinition = "NVARCHAR(50)")
	private String telephone;
	
	@Column(name="plantsection" , columnDefinition = "NVARCHAR(100)")
	private String plantSection;
	
	@Column(name="abcindicator" , columnDefinition = "NVARCHAR(30)")
	private String abcIndicator;
	
	@Column(name="sortfield" , columnDefinition = "NVARCHAR(200)")
	private String sortField;
	
	@Column(name="workcenter" , columnDefinition = "NVARCHAR(200)")
	private String workCenter;
	
	
	public LocationDataMaster()
	{
		super();
	}


	public String getLocationId() {
		return locationId;
	}


	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	public BasicDataMaster getId() {
		return id;
	}


	public void setId(BasicDataMaster id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
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


	@Override
	public String toString() {
		return "LocationDataMaster [locationId=" + locationId + ", id=" + id + ", maintenancePlant=" + maintenancePlant
				+ ", location=" + location + ", room=" + room + ", name=" + name + ", fax=" + fax + ", street=" + street
				+ ", telephone=" + telephone + ", plantSection=" + plantSection + ", abcIndicator=" + abcIndicator
				+ ", sortField=" + sortField + ", workCenter=" + workCenter + "]";
	}


	public LocationDataMaster(String locationId, BasicDataMaster id, String maintenancePlant, String location,
			String room, String name, String fax, String street, String telephone, String plantSection,
			String abcIndicator, String sortField, String workCenter) {
		super();
		this.locationId = locationId;
		this.id = id;
		this.maintenancePlant = maintenancePlant;
		this.location = location;
		this.room = room;
		this.name = name;
		this.fax = fax;
		this.street = street;
		this.telephone = telephone;
		this.plantSection = plantSection;
		this.abcIndicator = abcIndicator;
		this.sortField = sortField;
		this.workCenter = workCenter;
	}


	
	
	
}
