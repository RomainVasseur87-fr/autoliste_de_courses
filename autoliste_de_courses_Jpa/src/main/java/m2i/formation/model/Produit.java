package m2i.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	private String nom;
	private long quantite;
	@Transient
	private List<Categorie> categories;
	
	public Produit() {
		super();
	}
	public Produit(String nom, long quantite, List<Categorie> categories) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.categories = categories;
	}
	public Produit(long id, String nom, long quantite, List<Categorie> categories) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.categories = categories;
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
	public long getQuantite() {
		return quantite;
	}
	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", quantite=" + quantite + "]";
	}
	
	

}
