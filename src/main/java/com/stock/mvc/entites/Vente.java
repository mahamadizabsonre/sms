package com.stock.mvc.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vente")
public class Vente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long idVente;
	
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateVente;

	@OneToMany(mappedBy = "vente")
	private List<LigneVente> ligneVentes;
	
	
	
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDatevente() {
		return dateVente;
	}

	public void setDatevente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public List<LigneVente> getLigneVentes() {
		return ligneVentes;
	}

	public void setLigneVentes(List<LigneVente> ligneVentes) {
		this.ligneVentes = ligneVentes;
	}

	
	
	
}
