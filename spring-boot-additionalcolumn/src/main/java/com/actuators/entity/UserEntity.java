package com.actuators.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class UserEntity {

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int id, String name, String email, List<UsersRolesEntity> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.roles = roles;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.user", cascade = CascadeType.MERGE)
	private List<UsersRolesEntity> roles;

//	@CreationTimestamp
//	private Date createdAt;
//	@UpdateTimestamp
//	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UsersRolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<UsersRolesEntity> roles) {
		this.roles = roles;
	}

}
