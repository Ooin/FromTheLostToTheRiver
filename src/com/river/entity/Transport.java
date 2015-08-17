package com.river.entity;

public class Transport {

	private Integer id;
	private String name;

	public Transport() {
		super();
	}
	
	public Transport(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public Transport(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Transport))
			return false;
		Transport other = (Transport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transport [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name);
		builder.append("]");
		return builder.toString();
	}

}
