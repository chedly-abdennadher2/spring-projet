package application.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACHAT database table.
 * 
 */
@Embeddable
public class AchatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "numadh", unique = true, nullable = false, precision = 10, scale = 0)

	private long numadh;

	@Column(name = "numexemp", unique = true, nullable = false, precision = 4, scale = 0)

	private long numexemp;

	public AchatPK() {
	}
	public long getNumadh() {
		return this.numadh;
	}
	public void setNumadh(long numadh) {
		this.numadh = numadh;
	}
	public long getNumexemp() {
		return this.numexemp;
	}
	public void setNumexemp(long numexemp) {
		this.numexemp = numexemp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AchatPK)) {
			return false;
		}
		AchatPK castOther = (AchatPK)other;
		return 
			(this.numadh == castOther.numadh)
			&& (this.numexemp == castOther.numexemp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numadh ^ (this.numadh >>> 32)));
		hash = hash * prime + ((int) (this.numexemp ^ (this.numexemp >>> 32)));
		
		return hash;
	}
}