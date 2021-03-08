package m2i.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recette")

public class Recette {
	
	@Id
	@GeneratedValue
	private Long id;
//	@Version
//	private int version;
	@Column(name = "nom", length = 255)
	private String nom;
	@Column(name = "nbConvives", length = 255)
	private Long nbConvives;
	@OneToOne
	@JoinColumn(name = "process_id")
	private Process process;
	@ManyToMany
	@JoinTable(name = "ingredients", joinColumns = @JoinColumn(name = "recette_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
	private List<Produit> ingredients;
	@ManyToMany
	@JoinTable(name = "themes", joinColumns = @JoinColumn(name = "recette_id"), inverseJoinColumns = @JoinColumn(name = "theme_id"))
	private List<Theme> themes;
	
	public Recette() {
		
	}
	
	public Recette(Long id, String nom, Long nbConvives, Process process, List<Produit> ingredients,
			List<Theme> themes) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbConvives = nbConvives;
		this.process = process;
		this.ingredients = ingredients;
		this.themes = themes;
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

	public Long getnbConvives() {
		return nbConvives;
	}

	public void setnbConvives(Long nbConvives) {
		this.nbConvives = nbConvives;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public List<Produit> getIngredients() {
		return ingredients;
	}

	public void setIngerients(List<Produit> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	@Override
	public String toString() {
		return "Recette [id = " + this.getId() + ", nom = " + this.getNom() + ", nombre de convives = " + this.getnbConvives() + ", process = " + this.getProcess()
				+ ", ingrédients =" + this.getIngredients() + ", thèmes = " + this.getThemes() + "]";
	}
	
}