package com.assessment.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.assessment.entity.MyRoles;

public class MyUserAuthentication implements Authentication {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final String principal;
    private final String password;
    private final List<MyRoles> role;

    public MyUserAuthentication(String principal, String password, List<MyRoles> role) {
	this.principal = principal;
	this.password = password;
	this.role = role;
    }

    @Override
    public String getName() {
	return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	List<SimpleGrantedAuthority> sgaList = new ArrayList<>();
	role.stream().forEach(myRole -> {
	    SimpleGrantedAuthority sga = new SimpleGrantedAuthority(myRole.getRole());
	});
	return sgaList;
    }

    @Override
    public Object getCredentials() {
	return password;
    }

    @Override
    public Object getDetails() {
	return null;
    }

    @Override
    public Object getPrincipal() {
	return principal;
    }

    @Override
    public boolean isAuthenticated() {

	return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

}
