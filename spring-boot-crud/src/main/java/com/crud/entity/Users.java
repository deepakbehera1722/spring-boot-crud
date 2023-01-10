package com.crud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "users")
//***soft deleted***
@Where(clause = "is_active")
@SQLDelete(sql = "UPDATE users set is_active=false where user_id=?")
public class Users{
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "User_id")
	private Long id;

	private String name;
	private String email;
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updateAt;

	private boolean isActive=true;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Long id, String name, String email, Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
