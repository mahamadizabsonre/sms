package com.stock.mvc.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandefournisseur")
public class CommandeFournisseur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long idCommandeFournissuer;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "idFournisseur")
	private Fournisseur fournisseur;
	
	
	@OneToMany(mappedBy = "commandeFournisseurs")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
	
	public CommandeFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCommandeFournisseur> getLigneCommandeFournisseurs() {
		return ligneCommandeFournisseurs;
	}

	public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseur> ligneCommandeFournisseur) {
		this.ligneCommandeFournisseurs = ligneCommandeFournisseur;
	}

	public Long getIdCommandeFournissuer() {
		return idCommandeFournissuer;
	}

	public void setIdCommandeFournissuer(Long idCommandeFournissuer) {
		this.idCommandeFournissuer = idCommandeFournissuer;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	
	
	
}
