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
@Table(name = "lignecommandeclient")
public class LigneCommandeClient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long IdLigneCommandeclient;
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idCommandeClient")
	private CommandeClient commandeClient;
	
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public Long getIdLigneCommandeclient() {
		return IdLigneCommandeclient;
	}

	public void setIdLigneCommandeclient(Long idLigneCommandeclient) {
		IdLigneCommandeclient = idLigneCommandeclient;
	}
	
	

	
}
