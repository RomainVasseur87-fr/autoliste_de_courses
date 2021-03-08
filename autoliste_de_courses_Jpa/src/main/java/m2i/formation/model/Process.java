package m2i.formation.model;

public class Process {
	
	private Long id = 0L;
	private String nom = null;
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