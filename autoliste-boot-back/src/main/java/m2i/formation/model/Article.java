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
	private Long conditionement;
	@Column(name="prix")
	private Double prix;
	@OneToOne
	@JoinColumn (name = "magasin_id")
	private Magasin magasin;

	public Article() {
		super();
	}

	public Article(String nom, Long conditionement, Double prix, Magasin magasin) {
		super();
		this.nom = nom;
		this.conditionement = conditionement;
		this.prix = prix;
		this.magasin = magasin;
	}

	public Article(long id, String nom, Long conditionement, Double prix, Magasin magasin) {
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conditionement == null) ? 0 : conditionement.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((magasin == null) ? 0 : magasin.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		result = prime * result + version;
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
		Article other = (Article) obj;
		if (conditionement == null) {
			if (other.conditionement != null)
				return false;
		} else if (!conditionement.equals(other.conditionement))
			return false;
		if (id != other.id)
			return false;
		if (magasin == null) {
			if (other.magasin != null)
				return false;
		} else if (!magasin.equals(other.magasin))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
