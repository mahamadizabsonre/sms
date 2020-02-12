package com.stock.mvc.entites;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFournisseur;

	private String nom;

	private String prenom;

	private String adresse;

	private String photo;

	private String mail;

	@OneToMany(mappedBy = "fournisseur")
	private List<CommandeFournisseur> commandeFournisseurs;
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}



	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseur) {
		this.commandeFournisseurs = commandeFournisseur;
	}



	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
