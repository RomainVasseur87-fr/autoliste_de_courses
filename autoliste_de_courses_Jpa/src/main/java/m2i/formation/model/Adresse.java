package m2i.formation.model;

public class Adresse {

	private long id;
	private int numero;
	private String rue;
	private String complement;
	private String ville;
	private String codePostal;
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
