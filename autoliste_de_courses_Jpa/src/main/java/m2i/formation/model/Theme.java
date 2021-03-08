package m2i.formation.model;

public class Theme {
	
	private Long id = 0L;
	private String nom = null;
	
	public Theme() {
		super();
	}
	
	public Theme(Long id) {
		super();
		this.id = id;
	}
	public Theme(String nom) {
		super();
		this.nom = nom;
	}
	
	public Theme(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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
	
	@Override
	public String toString() {
		return "Thème [id = " + this.getId() + ", nom = " + this.getNom() + "]";
	}
	
}