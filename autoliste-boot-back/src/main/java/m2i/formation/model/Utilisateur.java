package m2i.formation.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@JsonView(IViews.IViewBasic.class)
	private String username;
	@JsonView(IViews.IViewBasic.class)
	private String password;
	@JsonView(IViews.IViewBasic.class)
	private boolean enable;
	@OneToMany(mappedBy = "user")
	@JsonView(IViews.IViewUtilisateurDetail.class)
	private Set<UtilisateurRole> roles;
	@OneToOne(fetch = FetchType.EAGER)
	@JsonView(IViews.IViewUtilisateurDetail.class)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Utilisateur() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<UtilisateurRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UtilisateurRole> roles) {
		this.roles = roles;
	}
	
	public List<String> getStringRoles() {
		List<String> stringRoles = new ArrayList<>();

		for (UtilisateurRole role : roles) {
			stringRoles.add("ROLE_"+role.getRole().name());
		}

		return stringRoles;
	}
	
}
