package com.sapiens.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sapiens.workshop.models.Client;
import com.sapiens.workshop.repo.ClientRepo;

@Service
public class ClientService {
	@Autowired
	ClientRepo repo;
	
	public void saveClient(Client c) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	    String encodedPassword = passwordEncoder.encode(c.getPassword());

	    c.setPassword(encodedPassword);
		repo.save(c);
	}
}
