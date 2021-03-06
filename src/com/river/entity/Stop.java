package com.river.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stop")
public class Stop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;

	@ManyToMany(mappedBy="stops",fetch= FetchType.EAGER)
	private List<Line> lines;
	
	
	
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
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
		this.address = adress;
	}

	public Stop(Address adress) {
		super();
		this.address = adress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address adress) {
		this.address = adress;
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
		if (address != null) {
			builder.append("adress=");
			builder.append(address);
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
