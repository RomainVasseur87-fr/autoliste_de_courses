package m2i.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Commande {

	@Id
	@GeneratedValue
	private long id;
	private String nom;
	@Transient
	private List<Article> articles;

	public Commande() {
		super();
	}

	public Commande(String nom, List<Article> articles) {
		super();
		this.nom = nom;
		this.articles = articles;
	}

	public Commande(long id, String nom, List<Article> articles) {
		super();
		this.id = id;
		this.nom = nom;
		this.articles = articles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", nom=" + nom + ", articles=" + articles + "]";
	}

}
