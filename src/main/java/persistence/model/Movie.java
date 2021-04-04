package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "movie")

@NamedQueries({
	@NamedQuery(name = "Movie_findByDirector", query = "SELECT m FROM Movie m WHERE m.director = :director"),
	@NamedQuery(name = "Movie_findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
	@NamedQuery(name = "Movie_findAll", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie_selectNewTO", query = "SELECT NEW business.dto.TOMovie(m)  from Movie m")
})



//@NamedQuery(name = "Movie_findAll", query = "Select a.fullname,m.title,m.director,m.writers from actor a, movie m where  a.id = m.actor")

public class Movie implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 3880345372694241930L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;
	@Column(name = "director")
	private String director;
	@Column(name = "writers")
	private String writers;
	@ManyToOne
	@JoinColumn(name = "fk_actor")
	private Actor actor;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriters() {
		return writers;
	}

	public void setWriters(String writers) {
		this.writers = writers;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
