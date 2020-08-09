package com.incture.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="GENERAL_MASTER")
@Data
public class GeneralDataMaster implements BaseData{

	
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BasicDataMaster id;
		
	@Column(name = "classtype")
	private String classType;

	@Column(name = "objecttype", columnDefinition = "NVARCHAR(30)")
	private String objectType;

	@Column(name = "weight")
	private float weight;

	@Column(name = "size", columnDefinition = "NVARCHAR(30)")
	private String size;

	@Column(name = "acquistnvalue")
	private int acquistnValue;

	@Column(name = "acquistndate")
	private Date acquistnDate;

	@Column(name = "manufacturer", columnDefinition = "NVARCHAR(50)")
	private String manufacturer;

	@Column(name = "manufacturerpartno", columnDefinition = "NVARCHAR(50)")
	private String manufacturerPartNo;

	@Column(name = "manufacturercountry", columnDefinition = "NVARCHAR(50)")
	private String manufacturerCountry;
	
	@Column(name = "manufacturerno", columnDefinition = "NVARCHAR(50)")
	private String manufacturerNo;

	@Column(name = "constyrmonth")
	private Date constYrMonth;
	
	public GeneralDataMaster()
	{
		super();
	}

	public BasicDataMaster getId() {
		return id;
	}

	public void setId(BasicDataMaster id) {
		this.id = id;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAcquistnValue() {
		return acquistnValue;
	}

	public void setAcquistnValue(int acquistnValue) {
		this.acquistnValue = acquistnValue;
	}

	public Date getAcquistnDate() {
		return acquistnDate;
	}

	public void setAcquistnDate(Date acquistnDate) {
		this.acquistnDate = acquistnDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerPartNo() {
		return manufacturerPartNo;
	}

	public void setManufacturerPartNo(String manufacturerPartNo) {
		this.manufacturerPartNo = manufacturerPartNo;
	}

	public String getManufacturerCountry() {
		return manufacturerCountry;
	}

	public void setManufacturerCountry(String manufacturerCountry) {
		this.manufacturerCountry = manufacturerCountry;
	}

	public String getManufacturerNo() {
		return manufacturerNo;
	}

	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
	}

	public Date getConstYrMonth() {
		return constYrMonth;
	}

	public void setConstYrMonth(Date constYrMonth) {
		this.constYrMonth = constYrMonth;
	}

	@Override
	public String toString() {
		return "GeneralDataMaster [id=" + id + ", classType=" + classType + ", objectType=" + objectType + ", weight="
				+ weight + ", size=" + size + ", acquistnValue=" + acquistnValue + ", acquistnDate=" + acquistnDate
				+ ", manufacturer=" + manufacturer + ", manufacturerPartNo=" + manufacturerPartNo
				+ ", manufacturerCountry=" + manufacturerCountry + ", manufacturerNo=" + manufacturerNo
				+ ", constYrMonth=" + constYrMonth + "]";
	}

	public GeneralDataMaster(BasicDataMaster id, String classType, String objectType, float weight, String size,
			int acquistnValue, Date acquistnDate, String manufacturer, String manufacturerPartNo,
			String manufacturerCountry, String manufacturerNo, Date constYrMonth) {
		super();
		this.id = id;
		this.classType = classType;
		this.objectType = objectType;
		this.weight = weight;
		this.size = size;
		this.acquistnValue = acquistnValue;
		this.acquistnDate = acquistnDate;
		this.manufacturer = manufacturer;
		this.manufacturerPartNo = manufacturerPartNo;
		this.manufacturerCountry = manufacturerCountry;
		this.manufacturerNo = manufacturerNo;
		this.constYrMonth = constYrMonth;
	}
	
	
	
	
	
}
