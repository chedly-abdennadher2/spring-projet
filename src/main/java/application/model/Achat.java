package application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACHAT database table.
 * 
 */
@Entity
public class Achat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AchatPK id;

	@Temporal(TemporalType.DATE)
	private Date dateachat;

	@ManyToOne
	@JoinColumn(name="NUMADH",insertable=false,updatable=false)
	private Adherent adherent;

	@ManyToOne
	@JoinColumn(name="NUMEXEMP",insertable=false,updatable=false)
	private Exemplaire exemplaire;

	public Achat() {
	}

	public AchatPK getId() {
		return this.id;
	}

	public void setId(AchatPK id) {
		this.id = id;
	}

	public Date getDateachat() {
		return this.dateachat;
	}

	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
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