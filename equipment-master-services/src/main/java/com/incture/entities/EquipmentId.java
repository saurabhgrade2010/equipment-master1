package com.incture.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EquipmentId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="id" , columnDefinition = "NVARCHAR(36)")
	private String id;
	
	@Column(name="version")
	private int version;
	
	public EquipmentId()
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

	public EquipmentId(String id, int version) {
		super();
		this.id = id;
		this.version = version;
	}

	@Override
	public String toString() {
		return "EquipmentId [id=" + id + ", version=" + version + "]";
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof EquipmentId)) return false;
	        EquipmentId that = ( EquipmentId) o;
	        return Objects.equals(getId(), that.getId()) &&
	                Objects.equals(getVersion(), that.getVersion());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getId(), getVersion());
	    }

}
