package remedium.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;

	private String name;

	//bi-directional many-to-one association to Rolelog
	@OneToMany(mappedBy="role")
	private List<Rolelog> rolelogs;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rolelog> getRolelogs() {
		return this.rolelogs;
	}

	public void setRolelogs(List<Rolelog> rolelogs) {
		this.rolelogs = rolelogs;
	}

	public Rolelog addRolelog(Rolelog rolelog) {
		getRolelogs().add(rolelog);
		rolelog.setRole(this);

		return rolelog;
	}

	public Rolelog removeRolelog(Rolelog rolelog) {
		getRolelogs().remove(rolelog);
		rolelog.setRole(null);

		return rolelog;
	}

}