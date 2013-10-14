package com.example;


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
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



@Entity
@Path("/Home")
public class Home {

	
	
	private Person owner;
	private Long id;
	
	
	
	public Home createHome(){
		
		
		return new Home("");
	}
	
	@Id
	@GeneratedValue
	@Column(name="HOME_ID")
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Long getId() {
		return id;
	}
	@PUT
	@Path("{id}")
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
	@GET
	@Path("{owner}")
	@Produces(MediaType.TEXT_PLAIN)
	public Person getOwner() {
		return owner;
	}
	@PUT
	@Path("set/{owner}")
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
	
	
	@GET
	@Path("{adress}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAdress() {
		return adress;
	}
	@PUT
	@Path("set/{adress}")
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@GET
	@Path("{superficie}")
	@Produces(MediaType.TEXT_PLAIN)
	public Integer getSuperficie() {
		return superficie;
	}
	@PUT
	@Path("set/{superficie}")
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	@GET
	@Path("{IP}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIP() {
		return IP;
	}
	@PUT
	@Path("set/{IP}")
	public void setIP(String iP) {
		IP = iP;
	}
	
}
