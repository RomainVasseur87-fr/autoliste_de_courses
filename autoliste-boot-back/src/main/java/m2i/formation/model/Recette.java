package m2i.formation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "recette")
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
	@OneToOne(cascade= {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "process_id")
	private Process process;
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}) 
	@JoinTable(name = "ingredients", joinColumns = @JoinColumn(name = "recette_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
	private List<Produit> ingredients;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "themes", joinColumns = @JoinColumn(name = "recette_id"), inverseJoinColumns = @JoinColumn(name = "theme_id"))
	private List<Theme> themes;
	@Column(name = "rating")
	private Integer rating;
	
	public Recette() {
		
	}
	
	public Recette(String nom, Long nbConvives, Process process, List<Produit> ingredients, List<Theme> themes, Integer rating) {
		super();
		this.nom = nom;
		this.nbConvives = nbConvives;
		this.process = process;
		this.ingredients = ingredients;
		this.themes = themes;
		this.rating = rating;
	}



	public Recette(Long id, String nom, Long nbConvives, Process process, List<Produit> ingredients,
			List<Theme> themes, Integer rating) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbConvives = nbConvives;
		this.process = process;
		this.ingredients = ingredients;
		this.themes = themes;
		this.rating = rating;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		if (rating <0 || rating >5) {
			throw new RuntimeException("la notation doit etre entre 0 et 5");
		} else {
		this.rating = rating;
		}
	}

	@Override
	public String toString() {
		return "Recette [id=" + id + ", version=" + version + ", nom=" + nom + ", nbConvives=" + nbConvives
				+ ", process=" + process + ", ingredients=" + ingredients + ", themes=" + themes + ", rating=" + rating
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((nbConvives == null) ? 0 : nbConvives.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((process == null) ? 0 : process.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((themes == null) ? 0 : themes.hashCode());
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recette other = (Recette) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (nbConvives == null) {
			if (other.nbConvives != null)
				return false;
		} else if (!nbConvives.equals(other.nbConvives))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (process == null) {
			if (other.process != null)
				return false;
		} else if (!process.equals(other.process))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (themes == null) {
			if (other.themes != null)
				return false;
		} else if (!themes.equals(other.themes))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	
}