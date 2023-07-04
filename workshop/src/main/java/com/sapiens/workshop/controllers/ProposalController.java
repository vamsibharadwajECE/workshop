package com.sapiens.workshop.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sapiens.workshop.models.Client;
import com.sapiens.workshop.models.Proposal;
import com.sapiens.workshop.repo.ClientRepo;
import com.sapiens.workshop.repo.ProposalRepo;
import com.sapiens.workshop.services.ClientService;
import com.sapiens.workshop.services.ProposalService;

@Controller
public class ProposalController {
	@Autowired
	ProposalService service;
	@Autowired
	ClientService service1;
	
	@Autowired
	ClientRepo repo;
	
	@Autowired
	ProposalRepo repo1;
	@RequestMapping("/")
	public String myhomepage() {
		return "newhome";
	}
	
//	@RequestMapping("/user/search")
//	public String searchContacts(@RequestParam("keyword") String keyword, Model model,Principal p) {
//		String name=p.getName();
//		User user=this.repo.getUserByUsername(name);
//		
//	    List<Contact> searchResults = service.searchContacts(keyword, user.getId());
//	    model.addAttribute("listContact", searchResults);
//	    return "contact"; // Assuming the name of the HTML template is "contact.html"
//	}
	@RequestMapping("/client/printpassword")
	public String printPassword(@RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,Principal p,RedirectAttributes redirAttrs) {
			String name=p.getName();
			Client client=repo.getClientByClientname(name);
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 if(passwordEncoder.matches(oldPassword, client.getPassword())) {
				 client.setPassword(newPassword); 
				 service1.saveClient(client);
			     redirAttrs.addFlashAttribute("success", "good");
				 return "redirect:/client/changepassword";
				 }
			 redirAttrs.addFlashAttribute("error", "wrong password");
		return "redirect:/client/changepassword";
	}
	@RequestMapping("/client/changepassword")
	public String changePassword() {
		return "newpassword";
	}
	@RequestMapping("/client/viewproposal")
	public String viewProposal(Model model,Principal p) 
	{
		String name = p.getName();
		 Client client = this.repo.getClientByClientname(name);
		 List<Proposal> proposal=repo1.getProposalsByClientId(client.getId());
		model.addAttribute("listProposal", proposal);
		return "proposal";
	}
	@RequestMapping("/client/addproposal")
	public String viewAddproducts(Model model) 
	{
		Proposal proposal=new Proposal();
		model.addAttribute("listProposal", proposal);
		return "addproposal";
	}
	@RequestMapping("/save")
	public String homePage(Proposal proposal, Client client) 
	{
		client.getProposals().add(proposal);
		proposal.setClient(client);
		service.saveData(proposal);
		return "home";
	}
	
	@RequestMapping("/client/paymentgateway")
	public String PaymentMode() {
		return "paymentmode";
	}
    @RequestMapping("/client/saveProposal")
    public String saveProposal(@ModelAttribute("proposal") Proposal proposal,Principal p) {
        // save employee to database
    	String name = p.getName();
    	 Client client = this.repo.getClientByClientname(name);
    	 client.getProposals().add(proposal);
    	 proposal.setClient(client);
        service.saveProposal(proposal);
        return "redirect:/client/viewproposal";
    }
    @RequestMapping("/client/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) 
    {

        // get employee from the service
        Proposal proposal = service.getProposalById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("listProposal", proposal);
        return "update";
    }

    @RequestMapping("/client/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) 
    {
        // call delete employee method 
        this.service.deleteProposalById(id);
        return "redirect:/client/viewproposal";
    }
    
    

}
