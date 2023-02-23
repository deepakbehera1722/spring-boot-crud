package com.actuators.entity;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId {

	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleId(UserEntity userEntity, RoleEntity roleEntity) {
		super();
		this.userEntity = userEntity;
		this.roleEntity = roleEntity;
	}

	private UserEntity userEntity;
	private RoleEntity roleEntity;

	@ManyToOne
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@ManyToOne
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleEntity, userEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleId other = (UserRoleId) obj;
		return Objects.equals(roleEntity, other.roleEntity) && Objects.equals(userEntity, other.userEntity);
	}

}
