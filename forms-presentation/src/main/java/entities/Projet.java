package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Projet {
	
	private int idProjet;
	private String nom;

	private Personnel responsable;
	
	private Date date_debut;
	private Date date_fin;
	private List<Personnel> personnel = new ArrayList<Personnel>();
	
	
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Projet(String nom, Personnel responsable, Date date_debut, Date date_fin, List<Personnel> personnel) {
		super();
		this.nom = nom;
		this.responsable = responsable;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.personnel = personnel;
	}
	
	
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Personnel getResponsable() {
		return responsable;
	}
	public void setResponsable(Personnel responsable) {
		this.responsable = responsable;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public List<Personnel> getPersonnel() {
		return personnel;
	}
	public void setPersonnel(List<Personnel> personnel) {
		this.personnel = personnel;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", nom=" + nom + ", responsable=" + responsable + ", date_debut="
				+ date_debut + ", date_fin=" + date_fin + ", personnel=" + personnel + "]";
	}
	
	

}
