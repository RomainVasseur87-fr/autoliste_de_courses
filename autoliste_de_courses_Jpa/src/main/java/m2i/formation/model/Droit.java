package m2i.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "droit")
public class Droit {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "libelle", length = 255)
	private String libelle;
	@Column(name = "action")
	private String action;
	//@Column(name = "create", nullable = false, columnDefinition = "BOOLEAN")
	//private boolean canCreate;
	//@Column(name = "read", nullable = false, columnDefinition = "TINYINT(1)")
	//private boolean canRead;
	//@Column(name = "update", nullable = false, columnDefinition = "TINYINT(1)")
	//private boolean canUpdate;
	//@Column(name = "delete", nullable = false, columnDefinition = "TINYINT(1)")
	//private boolean canDelete;
	@ManyToMany(mappedBy = "droits", fetch = FetchType.LAZY)
	private List<Type> types = new ArrayList<Type>();
	
	public Droit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Droit(String libelle, String action) {
		super();
		this.libelle = libelle;
		this.action = action;

	}
	
	public Droit(Long id, String libelle, String action) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.action = action;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	
	

}
