package business.dto;


import persistence.model.Movie;

public class TOMovie {
	private Integer id;
	private String title;
	private String director;
	private String writers;
	
	private boolean editingMode;
	
	public TOMovie(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle();
		this.director = movie.getDirector();
		this.writers = movie.getWriters();
		
		this.editingMode = false;
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

	public boolean isEditingMode() {
		return editingMode;
	}

	public void setEditingMode(boolean editingMode) {
		this.editingMode = editingMode;
	}
}
