package com.xworkz.spring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book_details")
public class BookDTO implements Serializable{

	@Id
	@GenericGenerator(name="books",strategy="increment")
	@GeneratedValue(generator="books")
	@Column(name="B_id")
	private int id;
	@Column(name="B_Name")
	private String name;
	@Column(name="B_Author")
	private String author;
	@Column(name="B_Price")
	private int price;
	@Column(name="B_Language")
	private String language;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", language="
				+ language + "]";
	}

	
}
