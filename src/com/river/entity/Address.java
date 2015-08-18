package com.river.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "zipCode")
	private Integer zipCode;
	@Column(name = "roadType")
	private String roadType;
	@Column(name = "roadName")
	private String roadName;
	
	@OneToOne
	@JoinColumn(name="stopId")
	private Stop stop;
	
	@OneToMany(mappedBy="origin")
	List<RouteStep> origins = new ArrayList<>();
	@OneToMany(mappedBy="destiny")
	List<RouteStep> destinies = new ArrayList<>();
	
	
	
	public Address(Integer zipCode, String roadType, String roadName) {
		super();
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
	}
	public Address(Integer zipCode, String roadType, String roadName, Stop stop, List<RouteStep> origins,
			List<RouteStep> destinies) {
		super();
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
		this.stop = stop;
		this.origins = origins;
		this.destinies = destinies;
	}
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
	public Stop getStop() {
		return stop;
	}
	public void setStop(Stop stop) {
		this.stop = stop;
	}
	public Address() {
		super();
	}
	
	public Address(Integer id) {
		super();
		this.id = id;
	}
	public Address(Integer id, Integer zipCode, String roadType,
			String roadName, Stop stop) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
		this.stop = stop;
	}
	
	public Address(Integer zipCode, String roadType,
			String roadName, Stop stop) {
		super();
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
		this.stop = stop;
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
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
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
		builder.append("Address [");
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
