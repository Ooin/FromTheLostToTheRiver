package com.river.entity;

public class Rate {
	
	private Integer id;
	private Rafter creator;
	private RouteFather route;
	private String comment;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Rafter getCreator() {
		return creator;
	}
	public void setCreator(Rafter creator) {
		this.creator = creator;
	}
	public RouteFather getRoute() {
		return route;
	}
	public void setRoute(RouteFather route) {
		this.route = route;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
		if (!(obj instanceof Rate))
			return false;
		Rate other = (Rate) obj;
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
		builder.append("Rate [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (creator != null) {
			builder.append("creator=");
			builder.append(creator);
			builder.append(", ");
		}
		if (route != null) {
			builder.append("route=");
			builder.append(route);
			builder.append(", ");
		}
		if (comment != null) {
			builder.append("comment=");
			builder.append(comment);
		}
		builder.append("]");
		return builder.toString();
	}
	public Rate(Integer id, Rafter creator, RouteFather route, String comment) {
		super();
		this.id = id;
		this.creator = creator;
		this.route = route;
		this.comment = comment;
	}
	public Rate(Integer id) {
		super();
		this.id = id;
	}
	public Rate() {
		super();
	}
	public Rate(Rafter creator, RouteFather route, String comment) {
		super();
		this.creator = creator;
		this.route = route;
		this.comment = comment;
	}
	
	
}
