package remedium.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArticle;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="article")
	private List<Comment> comments;

	//bi-directional many-to-one association to Upvote
	@OneToMany(mappedBy="article")
	private List<Upvote> upvotes;

	public Article() {
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setArticle(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setArticle(null);

		return comment;
	}

	public List<Upvote> getUpvotes() {
		return this.upvotes;
	}

	public void setUpvotes(List<Upvote> upvotes) {
		this.upvotes = upvotes;
	}

	public Upvote addUpvote(Upvote upvote) {
		getUpvotes().add(upvote);
		upvote.setArticle(this);

		return upvote;
	}

	public Upvote removeUpvote(Upvote upvote) {
		getUpvotes().remove(upvote);
		upvote.setArticle(null);

		return upvote;
	}

}