package m2i.formation.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "utilisateur_role")
public class UtilisateurRole {
	@Id
	@GeneratedValue
	@JsonView(IViews.IViewBasic.class)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "username")
	private Utilisateur user;
	@JsonView(IViews.IViewRoleDetail.class)
	@Enumerated(EnumType.STRING)
	private Role role;

	public UtilisateurRole(Utilisateur user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	public UtilisateurRole() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}