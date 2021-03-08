package m2i.formation.model;

import java.util.List;

public class Panier {
	
	private long id;
	private String nom;
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
