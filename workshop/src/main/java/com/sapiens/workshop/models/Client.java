package com.sapiens.workshop.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String clientname;
	private String password;
	private String email;
	private String role;
	
	@JsonIgnore
    @OneToMany(mappedBy = "client",cascade = CascadeType.MERGE,orphanRemoval = true)

    private List<Proposal> proposals=new ArrayList<>();
	
	public List<Proposal> getProposals() {
		return proposals;
	}
	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", clientname=" + clientname + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}
	public Client(String clientname, String password, String email, String role) {
		super();
		this.clientname = clientname;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public Client() {
		super();
	}
	
	
}
