package com.incture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GeneralDto extends BaseDto{
	

	
	private String id;
	private int version;
	private String classType;
	private String objectType;
	private float weight;
	private String size;                                                            
	private int acquistnValue;
	private String acquistnDate;
	private String manufacturer;
	private String manufacturerNo;
	private String manufacturerPartNo;
	private String 	manufacturerCountry;
	private String constYrMonth;
	
	
	public GeneralDto()
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


	public String getAcquistnDate() {
		return acquistnDate;
	}


	public void setAcquistnDate(String acquistnDate) {
		this.acquistnDate = acquistnDate;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getManufacturerNo() {
		return manufacturerNo;
	}


	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
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


	public String getConstYrMonth() {
		return constYrMonth;
	}


	public void setConstYrMonth(String constYrMonth) {
		this.constYrMonth = constYrMonth;
	}


	@Override
	public String toString() {
		return "GeneralDto [id=" + id + ", version=" + version + ", classType=" + classType + ", objectType="
				+ objectType + ", weight=" + weight + ", size=" + size + ", acquistnValue=" + acquistnValue
				+ ", acquistnDate=" + acquistnDate + ", manufacturer=" + manufacturer + ", manufacturerNo="
				+ manufacturerNo + ", manufacturerPartNo=" + manufacturerPartNo + ", manufacturerCountry="
				+ manufacturerCountry + ", constYrMonth=" + constYrMonth + "]";
	}


	
	
}
