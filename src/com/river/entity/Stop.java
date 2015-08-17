package com.river.entity;

public class Stop {
	
	
	private Integer id;
	private Address adress;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Address getAdress() {
		return adress;
	}
	
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	public Stop(Integer id) {
		super();
		this.id = id;
	}

	public Stop() {
		super();
	}

	public Stop(Integer id, Address adress) {
		super();
		this.id = id;
		this.adress = adress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StopD [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (adress != null) {
			builder.append("adress=");
			builder.append(adress);
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Stop))
			return false;
		Stop other = (Stop) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
