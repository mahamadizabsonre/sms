package com.stock.mvc.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long idLigneCommandeFournisseur;

	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idCommandeFournissuer")
	private CommandeFournisseur commandeFournisseurs;
	
	
	public LigneCommandeFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public CommandeFournisseur getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

	public void setCommandeFournisseurs(CommandeFournisseur commandeFournisseur) {
		this.commandeFournisseurs = commandeFournisseur;
	}

	public Long getIdLigneCommandeFournisseur() {
		return idLigneCommandeFournisseur;
	}

	public void setIdLigneCommandeFournisseur(Long idLigneCommandeFournisseur) {
		this.idLigneCommandeFournisseur = idLigneCommandeFournisseur;
	}
	
	
	
	
}
