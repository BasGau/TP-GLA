package fr.istic.tpjpa.jpa;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAddrMail() {
		return addrMail;
	}
	public void setAddrMail(String addrMail) {
		this.addrMail = addrMail;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProfFacebook() {
		return profFacebook;
	}
	public void setProfFacebook(String profFacebook) {
		this.profFacebook = profFacebook;
	}
	
	
}
