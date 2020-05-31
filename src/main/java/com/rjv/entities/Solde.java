package com.rjv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Solde implements Serializable {
	@Id @GeneratedValue
	private int id;
	private double solde;
	public int getId() {
		return id;
	}
	public Solde(double solde) {
		super();
		this.solde = solde;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Solde(int id, double solde) {
		super();
		this.id = id;
		this.solde = solde;
	}
	public Solde() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
