package m2i.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Article {
	
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	private long conditionement;
	private long prix;
	@Transient
	private Magasin fournisseur;

	public Article() {
		super();
	}

	public Article(String nom, long conditionement, long prix, Magasin fournisseur) {
		super();
		this.nom = nom;
		this.conditionement = conditionement;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}

	public Article(long id, String nom, long conditionement, long prix, Magasin fournisseur) {
		super();
		this.id = id;
		this.nom = nom;
		this.conditionement = conditionement;
		this.prix = prix;
		this.fournisseur = fournisseur;
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

	public Magasin getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Magasin fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", conditionement=" + conditionement + ", prix=" + prix
				+ ", fournisseur=" + fournisseur + "]";
	}

}
