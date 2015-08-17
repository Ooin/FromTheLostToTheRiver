package com.river.entity.dao;

public class AddressDAO {
	
	Integer id;
	Integer zipCode;
	String roadType;
	String roadName;
	StopDAO stop;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getRoadType() {
		return roadType;
	}
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public StopDAO getStop() {
		return stop;
	}
	public void setStop(StopDAO stop) {
		this.stop = stop;
	}
	public AddressDAO() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AddressDAO))
			return false;
		AddressDAO other = (AddressDAO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressDAO [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (zipCode != null) {
			builder.append("zipCode=");
			builder.append(zipCode);
			builder.append(", ");
		}
		if (roadType != null) {
			builder.append("roadType=");
			builder.append(roadType);
			builder.append(", ");
		}
		if (roadName != null) {
			builder.append("roadName=");
			builder.append(roadName);
			builder.append(", ");
		}
		if (stop != null) {
			builder.append("stopId=");
			builder.append(stop);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
