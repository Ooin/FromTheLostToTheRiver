package com.river.entity;

public class RouteSteps {
	private Integer id;
	private RouteFather route;
	private Address origin;
	private Address destiny;
	
	public RouteSteps(){
		
	}
	
	public RouteSteps(Integer id){
		this.id = id;
	}
	
	public RouteSteps(Integer id, RouteFather route, Address origin, Address destiny) {
		super();
		this.id = id;
		this.route = route;
		this.origin = origin;
		this.destiny = destiny;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RouteFather getRoute() {
		return route;
	}

	public void setRoute(RouteFather route) {
		this.route = route;
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
		if (!(obj instanceof RouteSteps)) {
			return false;
		}
		RouteSteps other = (RouteSteps) obj;
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
