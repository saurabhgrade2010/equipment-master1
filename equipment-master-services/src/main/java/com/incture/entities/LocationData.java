package com.incture.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity(name="LocationData")
@Table(name="locationdata")
@Data
public class LocationData implements BaseData {

	

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "locationid", columnDefinition = "NVARCHAR(36)")
	private String LocationId;
	
	/*
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH,})
	@JoinColumns(value = {
	    @JoinColumn(
	        name = "id", 
	        referencedColumnName = "id"
	    ),
	    @JoinColumn(
	        name = "version", 
	        referencedColumnName = "version"
	    )
	})
	private BasicData equipmentId;
	*/
	
	@Column(name="id" , columnDefinition = "NVARCHAR(36)")
	private String id;
	
	@Column(name="version")
	private int version;
	
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
	
	@Column(name="abcindicator" , columnDefinition = "NVARCHAR(10)")
	private String abcIndicator;
	
	@Column(name="sortfield" , columnDefinition = "NVARCHAR(200)")
	private String sortField;
	
	@Column(name="workcenter" , columnDefinition = "NVARCHAR(200)")
	private String workCenter;
	
	
	

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocationData()
	{
		super();
	}

	public String getLocationId() {
		return LocationId;
	}

	public void setLocationId(String locationId) {
		LocationId = locationId;
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
		return "LocationData [LocationId=" + LocationId + ", id=" + id + ", version=" + version + ", maintenancePlant="
				+ maintenancePlant + ", location=" + location + ", room=" + room + ", name=" + name + ", fax=" + fax
				+ ", street=" + street + ", telephone=" + telephone + ", plantSection=" + plantSection
				+ ", abcIndicator=" + abcIndicator + ", sortField=" + sortField + ", workCenter=" + workCenter + "]";
	}

	public LocationData(String locationId, String id, int version, String maintenancePlant, String location,
			String room, String name, String fax, String street, String telephone, String plantSection,
			String abcIndicator, String sortField, String workCenter) {
		super();
		LocationId = locationId;
		this.id = id;
		this.version = version;
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
