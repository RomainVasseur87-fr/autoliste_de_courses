package m2i.formation.model;

public class Categorie {
	
	private Long id = 0L;
	private String nom = null;
	
	public Categorie() {
		super();
	}
	
	public Categorie(Long id) {
		super();
		this.id = id;
	}
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	
	public Categorie(Long id, String nom) {
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
		return "Catégorie [id = " + this.getId() + ", nom = " + this.getNom() + "]";
	}


}