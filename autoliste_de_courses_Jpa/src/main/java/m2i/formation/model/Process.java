package m2i.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "process")
public class Process {
	
	@Id
	@GeneratedValue
	private Long id = 0L;
	@Version
	private int version;
	@Column(name = "nom", length = 255)
	private String nom = null;
	@Column(name = "description", length = 255)
	private String description = null;
	
	public Process() {
		super();
	}

	public Process(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Process(Long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Process [id = " + this.getId() + ", nom = " + this.getNom() + ", description = " + this.getDescription() + "]";
	}
	
}