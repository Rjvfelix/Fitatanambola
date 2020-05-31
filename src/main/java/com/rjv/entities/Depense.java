package com.rjv.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Depense implements Serializable {
	@Id @GeneratedValue
	private int id;
	private String description;
	private double montant;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Depense(String description, double montant, Date date) {
		super();
		this.description = description;
		this.montant = montant;
		this.date = date;
	}
	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
