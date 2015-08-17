package com.river.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="rafter")
public class Rafter {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "rafterName")
	private String rafterName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "registerDate")
	@Temporal(TemporalType.DATE)
	private Date registerDate; 

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRafterName() {
		return rafterName;
	}
	public void setRafterName(String rafterName) {
		this.rafterName = rafterName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public Rafter() {
		super();
	}
	
	public Rafter(String rafterName, String password, String email, Date registerDate) {
		super();
		
		this.rafterName = rafterName;
		this.password = password;
		this.email = email;
		this.registerDate = registerDate;
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
		if (!(obj instanceof Rafter))
			return false;
		Rafter other = (Rafter) obj;
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
		builder.append("Rafter [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (rafterName != null)
			builder.append("rafterName=").append(rafterName).append(", ");
		if (password != null)
			builder.append("password=").append(password).append(", ");
		if (email != null)
			builder.append("email=").append(email).append(", ");
		if (registerDate != null)
			builder.append("registerDate=").append(registerDate);
		builder.append("]");
		return builder.toString();
	}
}
