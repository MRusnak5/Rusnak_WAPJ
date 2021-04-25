package persistence.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name = "Book_findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
	@NamedQuery(name = "Book_findAll", query = "SELECT b FROM Book b"),
	@NamedQuery(name = "Book_selectNewTO", query = "SELECT NEW business.dto.TOBook(b)  from Book b")
	
	//ak pristupujem k property cez bodku tak generuje inner join
})



public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="title")
		
		@Size(max = 15)
		private String title;

		@ManyToOne
		@JoinColumn(name = "fk_autor")
		private Autor autor;
	
		@Transient
		private int age;
		
		@Transient
		private String autorFullName;
		
		public Autor getAutor() {
			return autor;
		}

		public void setAutor(Autor autor) {
			this.autor = autor;
		}

		public String getAutorFullName() {
			//if(this.autor == null) return "-";
		//	return this.autorFullName.getFirstName()+ " "+ this.autorFullName.getLastName();
			return autorFullName;
		}

		public void setAutorFullName(String autorFullName) {
			this.autorFullName = autorFullName;
		}

		//vytvorte vlastnu entitu, z realneho zivota napr filmy, entitu ktorej spravite reprezentaciu, namapujete atributy, 
		//( minimalne 5), dalšia entita a one to many a many to one, vytvorite jpql named queries, vyber všetkych zaznamov na oboch entitach a na zaklade podmienky(2 query)
		public Book() {
			super();
			//this.autorFullName = this.autor == null ? "." : this.autor.getFirstName()+ " " + this.autor.getLastName();
		}

	//	@PostConstruct
	//	private void init() {
	//		this.autorFullName = this.autor == null ? "." : this.autor.getFirstName()+ " " + this.autor.getLastName();
	//	}
		
		public Integer getId() {
			return id;
		}
		
		public Integer getAge() {
			return this.age;
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	

}
