package m2i.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table (name ="adresse")
public class Adresse {

	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	@Column(name="numero")
	private int numero;
	@Column(name="rue")
	private String rue;
	@Column(name="complement")
	private String complement;
	@Column(name="ville")
	private String ville;
	@Column(name="codePostal")
	private String codePostal;
	@Column(name="pays")
	private String pays;

	public Adresse() {
		super();
	}

	public Adresse(int numero, String rue, String complement, String ville, String codePostal, String pays) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.complement = complement;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public Adresse(long id, int numero, String rue, String complement, String ville, String codePostal, String pays) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.complement = complement;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", complement=" + complement + ", ville="
				+ ville + ", codePostal=" + codePostal + ", pays=" + pays + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((complement == null) ? 0 : complement.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + numero;
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + version;
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (complement == null) {
			if (other.complement != null)
				return false;
		} else if (!complement.equals(other.complement))
			return false;
		if (id != other.id)
			return false;
		if (numero != other.numero)
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (version != other.version)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

}
