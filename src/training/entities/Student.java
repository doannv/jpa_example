/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_id;
	private String s_name;
	@OneToMany(targetEntity = Library.class)
	private List<Library> books_issued;

	@ManyToMany(targetEntity = Library.class)
	private List<Library> lib;
	
	@ManyToOne  
  private Library library; 
	
	
	/**
	 * @return the library
	 */
	public Library getLibrary() {
		return library;
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(Library library) {
		this.library = library;
	}

	/**
	 * @return the lib
	 */
	public List<Library> getLib() {
		return lib;
	}

	/**
	 * @param lib
	 *          the lib to set
	 */
	public void setLib(List<Library> lib) {
		this.lib = lib;
	}

	/**
	 * @return the books_issued
	 */
	public List<Library> getBooks_issued() {
		return books_issued;
	}

	/**
	 * @param books_issued
	 *          the books_issued to set
	 */
	public void setBooks_issued(List<Library> books_issued) {
		this.books_issued = books_issued;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

}
