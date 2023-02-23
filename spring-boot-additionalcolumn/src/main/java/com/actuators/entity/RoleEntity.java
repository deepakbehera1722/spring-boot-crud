package com.actuators.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class RoleEntity {

	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleEntity(int id, String roleName, List<UsersRolesEntity> roles, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roles = roles;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String roleName;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.user", cascade = CascadeType.MERGE)
	private List<UsersRolesEntity> roles;
	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UsersRolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<UsersRolesEntity> roles) {
		this.roles = roles;
	}

}
