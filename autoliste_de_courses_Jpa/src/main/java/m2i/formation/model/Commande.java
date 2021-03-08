package m2i.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "nom")
	private String nom;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "articles", joinColumns = @JoinColumn(name = "commande_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
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
