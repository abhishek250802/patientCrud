package com.assessment.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.assessment.entity.MyRoles;

public class MyUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MyRoles> role;

    public List<MyRoles> getRole() {
	return role;
    }

    public void setRole(List<MyRoles> role) {
	this.role = role;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
