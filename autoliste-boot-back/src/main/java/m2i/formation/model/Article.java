package m2i.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "article")
public class Article {
	
	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	@Column(name="nom")
	private String nom;
	@Column(name="conditionement")
	private long conditionement;
	@Column(name="prix")
	private long prix;
	@OneToOne
	@JoinColumn (name = "magasin_id")
	private Magasin magasin;

	public Article() {
		super();
	}

	public Article(String nom, long conditionement, long prix, Magasin magasin) {
		super();
		this.nom = nom;
		this.conditionement = conditionement;
		this.prix = prix;
		this.magasin = magasin;
	}

	public Article(long id, String nom, long conditionement, long prix, Magasin magasin) {
		super();
		this.id = id;
		this.nom = nom;
		this.conditionement = conditionement;
		this.prix = prix;
		this.magasin = magasin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getConditionement() {
		return conditionement;
	}

	public void setConditionement(long conditionement) {
		this.conditionement = conditionement;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", conditionement=" + conditionement + ", prix=" + prix
				+ ", magasin=" + magasin + "]";
	}

}
