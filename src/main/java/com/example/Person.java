package com.example;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/Person")
public class Person {

	private String nom;
	private String prenom;
	private String genre;
	private String addrMail;
	private String dateNaissance;
	private String profFacebook;
	private Long id;
	private Set<Home> logements;
	private Set<Person> amis;

	
	
	
	public Person(String nom) {
		
		this.nom = nom;
		
	}

	public Person(String nom, String prenom, String genre, String addrMail,
			String dateNaissance, String profFacebook,
			Set<Home> logements, Set<Person> amis) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.addrMail = addrMail;
		this.dateNaissance = dateNaissance;
		this.profFacebook = profFacebook;
		this.logements = logements;
		this.amis = amis;
	}
	
	@OneToMany(mappedBy = "owner",cascade = CascadeType.PERSIST)
	@Column(nullable=true)
	public Set<Home> getLogements() {
		return logements;
	}
	public void setLogements(Set<Home> logements) {
		this.logements = logements;
	}
	@ManyToMany()
	@Column(nullable=true)
	public Set<Person> getAmis() {
		return amis;
	}
	public void setAmis(Set<Person> amis) {
		this.amis = amis;
	}
	
	
	@Id
	@GeneratedValue
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Long getId() {
		return id;
	}
	@PUT
	@Path("set/{id}")
	public void setId(Long id) {
		this.id = id;
	}
	@GET
	@Path("{nom}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNom() {
		return nom;
	}
	@PUT
	@Path("set/{nom}")
	public void setNom(String nom) {
		this.nom = nom;
	}
	@GET
	@Path("{prenom}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPrenom() {
		return prenom;
	}
	@PUT
	@Path("set/{prenom}")
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@GET
	@Path("{genre}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getGenre() {
		return genre;
	}
	@PUT
	@Path("set/{genre}")
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@GET
	@Path("{addrMail}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAddrMail() {
		return addrMail;
	}
	@PUT
	@Path("set/{addrMail}")
	public void setAddrMail(String addrMail) {
		this.addrMail = addrMail;
	}
	@GET
	@Path("{dateNaissance}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDateNaissance() {
		return dateNaissance;
	}
	@PUT
	@Path("set/{dateNaissance}")
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@GET
	@Path("{profFacebook}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getProfFacebook() {
		return profFacebook;
	}
	@PUT
	@Path("set/{profFacebook}")
	public void setProfFacebook(String profFacebook) {
		this.profFacebook = profFacebook;
	}
	
	
}
