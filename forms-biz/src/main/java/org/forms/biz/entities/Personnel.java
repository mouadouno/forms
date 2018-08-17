package org.forms.biz.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Personnel {
	
	@Id
	@GeneratedValue
	private int idPersonnel;
	private String nom;
	private String prenom;
	private String refog;
	private String statut;
	private Date date_integration;
	
	
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Personnel(String nom, String prenom, String refog, String statut, Date date_integration) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.refog = refog;
		this.statut = statut;
		this.date_integration = date_integration;
	}


	public int getIdPersonnel() {
		return idPersonnel;
	}


	public void setIdPersonnel(int idPersonnel) {
		this.idPersonnel = idPersonnel;
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


	public String getRefog() {
		return refog;
	}


	public void setRefog(String refog) {
		this.refog = refog;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Date getDate_integration() {
		return date_integration;
	}


	public void setDate_integration(Date date_integration) {
		this.date_integration = date_integration;
	}
	
	
}
