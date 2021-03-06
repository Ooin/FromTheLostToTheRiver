package com.river.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
public class Rate {

	/**
	 * CREATE TABLE `RATE` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
	 * UNIQUE, `creator` TEXT NOT NULL, `routeId` INTEGER NOT NULL, `comment`
	 * TEXT, FOREIGN KEY(creator) REFERENCES RAFTER(id), FOREIGN KEY(routeId)
	 * REFERENCES ROUTE_FATHER(id)
	 * 
	 * );
	 */

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "creator")
	private Rafter creator;

	@ManyToOne
	@JoinColumn(name = "routeId")
	private RouteFather route;

	@Column(name = "comment")
	private String comment;

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

}
