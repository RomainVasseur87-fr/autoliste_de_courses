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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "type")
public class Type {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nom", length = 255)
	private String nom;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "type_droits", joinColumns = @JoinColumn(name = "type_id"), inverseJoinColumns = @JoinColumn(name = "droit_id"))
	private List<Droit> droits = new ArrayList<Droit>();
	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Type(String nom, List<Droit> droits) {
		super();
		this.nom = nom;
		this.droits = droits;
	}


	public Type(Long id, String nom, List<Droit> droits) {
		super();
		this.id = id;
		this.nom = nom;
		this.droits = droits;
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


	public List<Droit> getDroits() {
		return droits;
	}


	public void setDroits(List<Droit> droits) {
		this.droits = droits;
	}


	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	
}
