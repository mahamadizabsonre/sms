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
@Table(name = "lignevente")
public class LigneVente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long IdLigneVente;

	@ManyToOne
	@JoinColumn(name = "idVente")
	private Vente vente;
	
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	 
	public Long getIdLigneVente() {
		return IdLigneVente;
	}

	public void setIdLigneVente(Long idLigneVente) {
		IdLigneVente = idLigneVente;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

		
	

	
}
