package m2i.formation.model;

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
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	@Column(name = "numero")
	private String nom;
	@ManyToMany
	@JoinTable(name = "panier_produits", joinColumns = @JoinColumn(name = "panier_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((produits == null) ? 0 : produits.hashCode());
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
		Panier other = (Panier) obj;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (produits == null) {
			if (other.produits != null)
				return false;
		} else if (!produits.equals(other.produits))
			return false;
		if (version != other.version)
			return false;
		return true;
	}


}
