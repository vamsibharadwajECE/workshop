package com.sapiens.workshop.config;

import org.springframework.security.core.userdetails.UserDetails;
import com.sapiens.workshop.models.Client;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MyClientDetails implements UserDetails {
	private Client client;
    
    public MyClientDetails(Client client) {
        this.client = client;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    		return null;
    }
 
    @Override
    public String getPassword() {
        return client.getPassword();
    }
 
    @Override
    public String getUsername() {
        return client.getClientname();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}
