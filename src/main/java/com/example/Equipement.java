package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Entity
@Path("/Equipement")
public class Equipement {
	
	private Home mezon;
	private String chauff;
	private Long id;

	
	public Equipement createEquipement(){
		
		return new Equipement("Boite");
		
	}
	
	public Equipement(String chauff) {
	
		this.chauff = chauff;
	}
	
	@GET
	@Path("{chauff}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getChauff() {
		return chauff;
	}
	@PUT
	@Path("set/{chauff}")
	public void setChauff(String chauff) {
		this.chauff = chauff;
	}
	@Id
	@GeneratedValue
	@Column(name="EQU_ID")
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEZON_ID")
	@GET
	@Path("{mezon}")
	@Produces(MediaType.TEXT_PLAIN)
	public Home getMezon() {
		return mezon;
	}
	@PUT
	@Path("set/{mezon}")
	public void setMezon(Home mezon) {
		this.mezon = mezon;
	}
	
	

}
