package com.digitalbooks.entity;

import java.sql.Clob;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class BookEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	/*
	 * @Column(name = "logo") private Blob logo;
	 */
	@Column(name = "title")
	private String title;
	
	
	@Column(name = "category")
	private String category;
	
	
	@Column(name = "price")
	private Double price;
	
	
	@Column(name = "author_id")
	private Long authorId;
	
	
	@Column(name = "publisher")
	private String publisher;
	

	@Column(name = "pub_date")
	private ZonedDateTime pubDate;
	

	@Column(name = "content")
	private Clob content;
	
	@Column(name = "is_active")
	private Boolean isActive;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public ZonedDateTime getPubDate() {
		return pubDate;
	}

	public void setPubDate(ZonedDateTime pubDate) {
		this.pubDate = pubDate;
	}

	public Clob getContent() {
		return content;
	}

	public void setContent(Clob content) {
		this.content = content;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
