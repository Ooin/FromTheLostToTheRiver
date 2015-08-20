package com.river.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "zipCode", unique = true)
	private Integer zipCode;
	@Column(name = "roadType")
	private String roadType;
	@Column(name = "roadName", unique = true)
	private String roadName;

	@OneToMany(mappedBy = "address")
	private List<Stop> stops;

	@OneToMany(mappedBy = "origin")
	List<RouteStep> origins;
	@OneToMany(mappedBy = "destiny")
	List<RouteStep> destinies;

	public Address(Integer zipCode, String roadType, String roadName) {
		super();
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
	}

	public Address(Integer id, Integer zipCode, String roadType, String roadName) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
	}

	public Address(Integer id, Integer zipCode, String roadType, String roadName, List<Stop> stops,
			List<RouteStep> origins, List<RouteStep> destinies) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
		this.stops = stops;
		this.origins = origins;
		this.destinies = destinies;
	}

	public Address(Integer zipCode, String roadType, String roadName, List<Stop> stops, List<RouteStep> origins,
			List<RouteStep> destinies) {
		super();
		this.zipCode = zipCode;
		this.roadType = roadType;
		this.roadName = roadName;
		this.stops = stops;
		this.origins = origins;
		this.destinies = destinies;
	}

	public Address() {
		super();
	}
	
	

	public Address(Integer id) {
		super();
		this.id = id;
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
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (zipCode != null)
			builder.append("zipCode=").append(zipCode).append(", ");
		if (roadType != null)
			builder.append("roadType=").append(roadType).append(", ");
		if (roadName != null)
			builder.append("roadName=").append(roadName).append(", ");
		if (stops != null)
			builder.append("stops=").append(stops);
		builder.append("]");
		return builder.toString();
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

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	public List<RouteStep> getOrigins() {
		return origins;
	}

	public void setOrigins(List<RouteStep> origins) {
		this.origins = origins;
	}

	public List<RouteStep> getDestinies() {
		return destinies;
	}

	public void setDestinies(List<RouteStep> destinies) {
		this.destinies = destinies;
	}

}
