package remedium.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private byte archived;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	private String email;

	private String login;

	private String password;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="user")
	private List<Article> articles;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Rolelog
	@OneToMany(mappedBy="user")
	private List<Rolelog> rolelogs;

	//bi-directional many-to-one association to Upvote
	@OneToMany(mappedBy="user")
	private List<Upvote> upvotes;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public byte getArchived() {
		return this.archived;
	}

	public void setArchived(byte archived) {
		this.archived = archived;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setUser(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setUser(null);

		return article;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<Rolelog> getRolelogs() {
		return this.rolelogs;
	}

	public void setRolelogs(List<Rolelog> rolelogs) {
		this.rolelogs = rolelogs;
	}

	public Rolelog addRolelog(Rolelog rolelog) {
		getRolelogs().add(rolelog);
		rolelog.setUser(this);

		return rolelog;
	}

	public Rolelog removeRolelog(Rolelog rolelog) {
		getRolelogs().remove(rolelog);
		rolelog.setUser(null);

		return rolelog;
	}

	public List<Upvote> getUpvotes() {
		return this.upvotes;
	}

	public void setUpvotes(List<Upvote> upvotes) {
		this.upvotes = upvotes;
	}

	public Upvote addUpvote(Upvote upvote) {
		getUpvotes().add(upvote);
		upvote.setUser(this);

		return upvote;
	}

	public Upvote removeUpvote(Upvote upvote) {
		getUpvotes().remove(upvote);
		upvote.setUser(null);

		return upvote;
	}

}