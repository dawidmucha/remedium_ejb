package remedium.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the upvote database table.
 * 
 */
@Entity
@NamedQuery(name="Upvote.findAll", query="SELECT u FROM Upvote u")
public class Upvote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUpvote;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

	public Upvote() {
	}

	public int getIdUpvote() {
		return this.idUpvote;
	}

	public void setIdUpvote(int idUpvote) {
		this.idUpvote = idUpvote;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}