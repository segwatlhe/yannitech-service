package com.yannitech.bookstore.yannitech.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private long id;
    private String category;
    @Column(name = "title")
    private String title;
    private String year;
    private Double price;
 
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonManagedReference
    //@Transient
    private List<Author> authors=new ArrayList<Author>();
    
    protected Book() {
    }
    
	public Book(long id, String category, String title, String year, Double price, List<Author> authors) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.year = year;
		this.price = price;
		this.authors = authors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthorList(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", category=" + category + ", title=" + title + ", year=" + year + ", price=" + price
				+ ", authors=" + authors + "]";
	}
}