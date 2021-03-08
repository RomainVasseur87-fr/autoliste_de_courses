package m2i.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "Recette")

public class Recette {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nom", length = 255)
	private String nom;
	@Column(name = "nbConvives", length = 255)
	private Long nbConvives;
	@Transient
	private Process process;
	@Transient
	private List<Produit> ingredients;
	@Transient
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