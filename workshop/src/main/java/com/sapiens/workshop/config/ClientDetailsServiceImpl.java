package com.sapiens.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.sapiens.workshop.models.Client;
import com.sapiens.workshop.repo.ClientRepo;

public class ClientDetailsServiceImpl implements UserDetailsService {
	 @Autowired
	    private ClientRepo clientRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String clientname)
	            throws UsernameNotFoundException {
	        Client client = clientRepository.getClientByClientname(clientname);
	         
	        if (client == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new MyClientDetails(client);
	    }
	 

}
