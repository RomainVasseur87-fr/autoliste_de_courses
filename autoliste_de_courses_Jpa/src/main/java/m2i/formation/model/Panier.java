package m2i.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "nom")
	private String nom;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "produits", joinColumns = @JoinColumn(name = "panier_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
	private List<Produit> produits;

	public Panier() {
		super();
	}

	public Panier(String nom, List<Produit> produits) {
		super();
		this.nom = nom;
		this.produits = produits;
	}

	public Panier(long id, String nom, List<Produit> produits) {
		super();
		this.id = id;
		this.nom = nom;
		this.produits = produits;
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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
	}

}
