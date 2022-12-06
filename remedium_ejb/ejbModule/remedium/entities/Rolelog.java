package remedium.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rolelog database table.
 * 
 */
@Entity
@NamedQuery(name="Rolelog.findAll", query="SELECT r FROM Rolelog r")
public class Rolelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRoleLog;

	private Timestamp createdAt;

	private Timestamp revokedAt;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Rolelog() {
	}

	public int getIdRoleLog() {
		return this.idRoleLog;
	}

	public void setIdRoleLog(int idRoleLog) {
		this.idRoleLog = idRoleLog;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getRevokedAt() {
		return this.revokedAt;
	}

	public void setRevokedAt(Timestamp revokedAt) {
		this.revokedAt = revokedAt;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}