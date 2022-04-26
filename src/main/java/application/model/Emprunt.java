package application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EMPRUNT database table.
 * 
 */
@Entity
public class Emprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmpruntPK id;

	@Temporal(TemporalType.DATE)
	private Date dateemprunt;

	@Temporal(TemporalType.DATE)
	private Date dateretourp;

	//bi-directional many-to-one association to Adherent
	@ManyToOne
	@JoinColumn(name="NUMADH",insertable=false,updatable=false)
	private Adherent adherent;

	//bi-directional many-to-one association to Exemplaire
	@ManyToOne
	@JoinColumn(name="NUMEXEMP",insertable=false,updatable=false)
	private Exemplaire exemplaire;

	public Emprunt() {
	}

	public EmpruntPK getId() {
		return this.id;
	}

	public void setId(EmpruntPK id) {
		this.id = id;
	}

	public Date getDateemprunt() {
		return this.dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public Date getDateretourp() {
		return this.dateretourp;
	}

	public void setDateretourp(Date dateretourp) {
		this.dateretourp = dateretourp;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Exemplaire getExemplaire() {
		return this.exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

}