package m2i.formation.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nom", length = 255)
	private String nom;
	@Column(name = "prenom", length = 255)
	private String prenom;
	@Column(name = "email", length = 255)
	private String email;
	@ManyToOne
	@JoinColumn(name="type_id")
	private Type type;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utilisateur_recettes", joinColumns = @JoinColumn(name = "utilisateur.id"), inverseJoinColumns = @JoinColumn(name = "recette_id"))
	private List<Recette> recettes = new ArrayList<Recette>();

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(String nom, String prenom, String email, Type type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.type = type;
	}

	public Utilisateur(Long id, String nom, String prenom, String email, Type type) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}
	
	
	
}
