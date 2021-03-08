package m2i.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Recette")

public class Recette {
	private Long id;
	private String nom;
	private Long NbConvives;
	private Process process;
	
	private List<Produit> ingredients;
	private List<Theme> themes;
	
	public Recette() {
		
	}
	
	public Recette(Long id, String nom, Long nbConvives, Process process, List<Produit> ingredients,
			List<Theme> themes) {
		super();
		this.id = id;
		this.nom = nom;
		NbConvives = nbConvives;
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

	public Long getNbConvives() {
		return NbConvives;
	}

	public void setNbConvives(Long nbConvives) {
		NbConvives = nbConvives;
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
		return "Recette [id = " + this.getId() + ", nom = " + this.getNom() + ", nombre de convives = " + this.getNbConvives() + ", process = " + this.getProcess()
				+ ", ingrédients =" + this.getIngredients() + ", thèmes = " + this.getThemes() + "]";
	}
	
}