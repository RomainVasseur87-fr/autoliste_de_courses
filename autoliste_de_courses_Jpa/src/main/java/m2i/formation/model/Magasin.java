package m2i.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Magasin {
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	@Transient
	private Adresse adresse;
	
	public Magasin() {
		super();
	}
	public Magasin(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}
	public Magasin(long id, String nom, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Magasin [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
	

}
