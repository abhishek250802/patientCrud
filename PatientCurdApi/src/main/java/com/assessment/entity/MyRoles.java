package com.assessment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class MyRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @NotNull
    private String role;

    public int getRoleId() {
	return roleId;
    }

    public void setRoleId(int roleId) {
	this.roleId = roleId;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

}