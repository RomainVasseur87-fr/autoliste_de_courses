package m2i.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	@Column(name = "nom")
	private String nom;
	@Column(name = "quantite")
	private long quantite;
	@ManyToMany
	@JoinTable(name = "produit_categories", joinColumns = @JoinColumn(name = "produit_id"), inverseJoinColumns = @JoinColumn(name = "categorie_id"))
	private List<Categorie> categories = new ArrayList<Categorie>();

	public Produit() {
		super();
	}

	public Produit(String nom, long quantite) {
		super();
		this.nom = nom;
		this.quantite = quantite;
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
	
	public void addCategorie(Categorie categorie) {
		this.categories.add(categorie);
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", quantite=" + quantite + "]";
	}

}
