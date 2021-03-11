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

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", complement=" + complement + ", ville="
				+ ville + ", codePostal=" + codePostal + ", pays=" + pays + "]";
	}

}
