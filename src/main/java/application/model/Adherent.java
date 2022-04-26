package application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import javax.persistence.Table;

@Entity
@Table (name="ADHERENT",schema="projetspring")
public class Adherent implements Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;

	private String email;

	private String nom;

	private String prenom;

//	@OneToMany(mappedBy="adherent")
	//private List<Achat> achats;

	//@OneToMany(mappedBy="adherent")

//	private List<Emprunt> emprunts;
	private static final long serialVersionUID = 1L;

	public Adherent() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
/*
	public List<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Achat addAchat(Achat achat) {
		getAchats().add(achat);
		achat.setAdherent(this);

		return achat;
	}

	public Achat removeAchat(Achat achat) {
		getAchats().remove(achat);
		achat.setAdherent(null);

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
		emprunt.setAdherent(this);

		return emprunt;
	}

	public Emprunt removeEmprunt(Emprunt emprunt) {
		getEmprunts().remove(emprunt);
		emprunt.setAdherent(null);

		return emprunt;
	}
*/
	@Override
	public String toString() {
		return "Adherent [id=" + id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", achats=" 
	//+ achats
				//+ ", emprunts=" + emprunts 
				+ "]";
	}

}