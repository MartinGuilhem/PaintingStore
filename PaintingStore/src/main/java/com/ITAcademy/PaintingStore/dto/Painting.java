package com.ITAcademy.PaintingStore.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "painting")
public class Painting {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	String title;
	@Column(columnDefinition = "varchar(255) default 'Anonymous'")
	private String author;
	@Column
	Double price;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date date;

	// Entities relationship
	@ManyToOne()
	@JoinColumn(name = "store_id")
	private Store store;

	// CONSTRUCTORS
	public Painting() {
	}

	public Painting(Long id, String title, String author, Double price, Store store) {
		
		this.id = id;
		this.title = title;
		this.author = addAuthor(author);
		this.price = price;
		this.date = new Date(System.currentTimeMillis());
		this.store = store;
	}

	//GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = addAuthor(author);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	// METHODS

	// Set author as Anonymous if author is null
	private String addAuthor(String author) {
		if (author == null) {
			author = "Anonymous";
		}
		return author;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", title= " + title + ", author name=" + author + ", price=" + price
				+ " €, entry date=" + date + ", location=" + store.getName() + "]";
	}

}
