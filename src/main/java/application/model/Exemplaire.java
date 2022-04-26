package application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EXEMPLAIRE database table.
 * 
 */
@Entity

public class Exemplaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMEXEMPLAIRE", unique = true, nullable = false, precision = 4, scale = 0)
	private long numexemplaire;

	@OneToMany(mappedBy="exemplaire",cascade=CascadeType.ALL)
	private List<Achat> achats;
	@OneToMany(mappedBy="exemplaire")
	private List<Emprunt> emprunts;

	private String disponible;
		
	private BigDecimal prix;
	
	@ManyToOne
	@JoinColumn(name="NUMISBN",insertable=false,updatable=false)
	private Livre livre;

	public Exemplaire() {

	}

	public long getNumexemplaire() {
		return this.numexemplaire;
	}

	public void setNumexemplaire(long numexemplaire) {
		this.numexemplaire = numexemplaire;
	}

	public String getDisponible() {
		return this.disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre l) {
		this.livre = l;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public List<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Achat addAchat(Achat achat) {
		getAchats().add(achat);
		achat.setExemplaire(this);

		return achat;
	}

	public Achat removeAchat(Achat achat) {
		getAchats().remove(achat);
		achat.setExemplaire(null);

		return achat;
	}

	public List<Emprunt> getEmprunts() {
		return this.emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public Emprunt addEmprunt(Emprunt emprunt) {
		getEmprunts().add(emprunt);
		emprunt.setExemplaire(this);

		return emprunt;
	}

	public Emprunt removeEmprunt(Emprunt emprunt) {
		getEmprunts().remove(emprunt);
		emprunt.setExemplaire(null);

		return emprunt;
	}

	@Override
	public String toString() {
		return "Exemplaire [numexemplaire=" + numexemplaire 
	//			+ ", achats=" + achats + ", emprunts=" + emprunts
				+ ", disponible=" + disponible + ", prix=" + prix + "]";
	}

}