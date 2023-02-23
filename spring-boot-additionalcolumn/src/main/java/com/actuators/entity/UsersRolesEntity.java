package com.actuators.entity;

import java.sql.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "user_role")
@Entity
@AssociationOverrides({ @AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "user_id")),
		@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "role_id")) })
public class UsersRolesEntity {

	private UserRoleId pk = new UserRoleId();

	private Date createdAt;

	private Date updatedAt;

	@EmbeddedId
	public UserRoleId getPk() {
		return pk;
	}

	public void setPk(UserRoleId pk) {
		this.pk = pk;
	}

	@CreationTimestamp
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@UpdateTimestamp
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
