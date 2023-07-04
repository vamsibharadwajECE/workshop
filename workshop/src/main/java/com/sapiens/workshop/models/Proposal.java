package com.sapiens.workshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Proposal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String first_name;
	private String last_name;
	private String phoneno;
	private String email;
	@ManyToOne      
    private Client client;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Proposal(String first_name, String last_name, String phoneno, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phoneno = phoneno;
		this.email = email;
	}
	public Proposal() {
		super();
	}
	
}
