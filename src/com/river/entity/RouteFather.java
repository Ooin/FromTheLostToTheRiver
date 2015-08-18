package com.river.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROUTE_FATHER")
public class RouteFather {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="hashTag")
	private String hashTag;
	@Column(name="timeStamp")
	private String timeStamp;
	
	@ManyToOne
	@JoinColumn(name = "creator")
	private Rafter creator;
	
	@OneToMany(mappedBy ="route")
	List<Rate> rates = new ArrayList<>();
	
	public void addRate(Rate rate){
		this.rates.add(rate);
	}
	
	@OneToMany(mappedBy ="route")
	List<RouteStep> routeSteps = new ArrayList<>();
	
	public void addRouteStep(RouteStep routeStep){
		this.routeSteps.add(routeStep);
	}
	
	public RouteFather(){
	}
	
	public RouteFather(Integer id){
		this.id = id;
	}

	public RouteFather(Integer id, String title, String description, String hashTag, String timeStamp, Rafter creator) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.hashTag = hashTag;
		this.timeStamp = timeStamp;
		this.creator = creator;
	}
	
	

	public RouteFather(String title, String description, String hashTag, String timeStamp, Rafter creator) {
		super();
		this.title = title;
		this.description = description;
		this.hashTag = hashTag;
		this.timeStamp = timeStamp;
		this.creator = creator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Rafter getCreator() {
		return creator;
	}

	public void setCreator(Rafter creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteFather [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		if (hashTag != null) {
			builder.append("hashTag=");
			builder.append(hashTag);
		}
		builder.append("]");
		return builder.toString();
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RouteFather)) {
			return false;
		}
		RouteFather other = (RouteFather) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	
}
