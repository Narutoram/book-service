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
}
