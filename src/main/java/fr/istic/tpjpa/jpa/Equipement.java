package fr.istic.tpjpa.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipement {
	
	private Home mezon;
	private String chauff;
	private Long id;

	
	public Equipement(String chauff) {
	
		this.chauff = chauff;
	}
	public String getChauff() {
		return chauff;
	}
	public void setChauff(String chauff) {
		this.chauff = chauff;
	}
	@Id
	@GeneratedValue
	@Column(name="EQU_ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEZON_ID")
	public Home getMezon() {
		return mezon;
	}
	public void setMezon(Home mezon) {
		this.mezon = mezon;
	}
	
	

}
