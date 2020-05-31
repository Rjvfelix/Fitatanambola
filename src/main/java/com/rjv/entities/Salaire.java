package com.rjv.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Salaire implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String description;
	private double montant;
	private Date date;
	
	public Salaire() {
		super();
	}
	public Salaire(String description, double montant, Date date) {
		super();
		this.description = description;
		this.montant = montant;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
