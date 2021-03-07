package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "book")

@NamedQuery(name = "Book_findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")


public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="title")
		private String title;

		@ManyToOne
		@JoinColumn(name = "fk_autor")
		private Autor autor;
		
		//vytvorte vlastnu entitu, z realneho zivota napr filmy, entitu ktorej spravite reprezentaciu, namapujete atributy, 
		//( minimalne 5), dalšia entita a one to many a many to one, vytvorite jpql named queries, vyber všetkych zaznamov na oboch entitach a na zaklade podmienky(2 query)
		public Book() {
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	

}
