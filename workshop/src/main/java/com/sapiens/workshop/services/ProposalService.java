package com.sapiens.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapiens.workshop.models.Proposal;
import com.sapiens.workshop.repo.ProposalRepo;



@Service
public class ProposalService {
	
	@Autowired
	ProposalRepo repo;
	
	public List<Proposal> listAll(){
		return repo.findAll();
	}
	
	public void saveData(Proposal p) {
		repo.save(p);
	}
	
    public Proposal getProposalById(int id) {
        Optional < Proposal > optional = repo.findById(id);
        Proposal proposal = null;
        if (optional.isPresent()) {
            proposal = optional.get();
        } else {
            throw new RuntimeException(" Proposal not found for id :: " + id);
        }
        return proposal;
    }
    
//    public List<Contact> getContactByKeyword(String keyword){
//    	return repo.findByKeyword(keyword);
//    }
    public void deleteProposalById(int id) {
        this.repo.deleteById(id);
    }
    public void saveProposal(Proposal proposal) {
        this.repo.save(proposal);
    }

//	public List<Contact> searchContacts(String keyword,int id) {
//        List<Contact> searchResults = repo.findByNameContainingIgnoreCase(keyword,id);
//
//        return searchResults;
//	}


}
