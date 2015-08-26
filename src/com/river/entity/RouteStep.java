package com.river.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="route_steps")
public class RouteStep {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToMany(mappedBy ="routeSteps")
	private List<RouteFather> routeFathers;
	
	@ManyToOne
	@JoinColumn(name="origin")
	private Address origin;
	
	@ManyToOne
	@JoinColumn(name="destiny")
	private Address destiny;
	
	public RouteStep(){
		
	}
	
	public RouteStep(Integer id){
		this.id = id;
	}
	
	public RouteStep(Integer id, Address origin, Address destiny) {
		super();
		this.id = id;
		this.origin = origin;
		this.destiny = destiny;
	}
	
	

	public RouteStep(Address origin, Address destiny) {
		super();
		this.origin = origin;
		this.destiny = destiny;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public List<RouteFather> getRouteFathers() {
		return routeFathers;
	}

	public void setRouteFathers(List<RouteFather> routeFathers) {
		this.routeFathers = routeFathers;
	}

	public Address getOrigin() {
		return origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public Address getDestiny() {
		return destiny;
	}

	public void setDestiny(Address destiny) {
		this.destiny = destiny;
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
		if (!(obj instanceof RouteStep)) {
			return false;
		}
		RouteStep other = (RouteStep) obj;
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
