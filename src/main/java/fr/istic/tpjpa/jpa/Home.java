package fr.istic.tpjpa.jpa;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Home {

	
	
	private Person owner;
	private Long id;
	@Id
	@GeneratedValue
	@Column(name="HOME_ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String adress;
	private Integer superficie;
	private String IP;
	private Set<Equipement> eq;
	
	public Home(String adress){
		this.adress = adress;
	}
	
	public Home(String adress, Integer superficie, String iP ,Set<Equipement> eq) {
		super();
		this.eq = eq;
		this.adress = adress;
		this.superficie = superficie;
		IP = iP;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNER_ID")
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	@OneToMany(mappedBy = "mezon",cascade = CascadeType.PERSIST)
	public Set<Equipement> getEq() {
		return eq;
	}
	public void setEq(Set<Equipement> eq) {
		this.eq = eq;
	}
	
	
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
}
