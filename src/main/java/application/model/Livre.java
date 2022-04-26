package application.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the LIVRE database table.
 * 
 */
@Entity
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_ISBN", unique = true, nullable = false, precision = 10, scale = 0)
	private long numIsbn;

	private String auteur;
	private String dateedition;

	private String libelle;
	@OneToMany (mappedBy="livre",cascade=CascadeType.ALL)
    List <Exemplaire>exemplaires;
	public Livre() {
	}

	public long getNumIsbn() {
		return this.numIsbn;
	}

	public void setNumIsbn(long numIsbn) {
		this.numIsbn = numIsbn;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDateedition() {
		return this.dateedition;
	}

	public void setDateedition(String dateedition) {
		this.dateedition = dateedition;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	@Override
	public String toString() {
		return "Livre [numIsbn=" + numIsbn + ", auteur=" + auteur + ", dateedition=" + dateedition + ", libelle="
				+ libelle + ", exemplaires=" + exemplaires + "]";
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

}