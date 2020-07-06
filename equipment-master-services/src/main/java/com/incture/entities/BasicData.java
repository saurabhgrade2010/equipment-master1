package com.incture.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Entity
@Table(name = "BASIC")
@Data
public class BasicData implements BaseDo {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID", columnDefinition = "NVARCHAR(36)")
	private String id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description" , columnDefinition = "NVARCHAR(100)")
	private String description;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "available")
	private int available;
	
	@Column(name = "validFrom")
	@Temporal(TemporalType.DATE)
	private Date validFrom;
	
	@Column(name = "validTo")
	@Temporal(TemporalType.DATE)
	private Date validTo;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BasicData [id=" + id + ", category=" + category + ", description=" + description + ", status=" + status
				+ ", available=" + available + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}

	
	
}
