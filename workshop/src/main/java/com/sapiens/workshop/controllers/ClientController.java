package com.sapiens.workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapiens.workshop.models.Client;
import com.sapiens.workshop.services.ClientService;

@Controller
public class ClientController {
	@Autowired
	ClientService service;
	@RequestMapping("/proposal")
	public String viewlog(Model model) 
	{
		Client client=new Client();
		model.addAttribute("bindclient",client);
		return "proposal";
	}
	
	@RequestMapping("/register")
	public String viewClient(Model model) 
	{
		Client client=new Client();
		model.addAttribute("bindclient",client);
		return "client";
	}
    @RequestMapping("/saveClient")
    public String saveProposal(@ModelAttribute("bindclient") Client client) {
        // save employee to database
    	client.setRole("USER");
        service.saveClient(client);
        return "redirect:/";
    }
}
