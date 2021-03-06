package pl.marekhacieja.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_book")
	private Long id;
	
	@NotEmpty(message = "{pl.marekhacieja.model.Book.title.NotEmpty}")
	@Column(name = "book_title")
	private String title;

	@NotEmpty(message = "{pl.marekhacieja.model.Book.author.NotEmpty}")
	@Column(name = "author")
	private String author;

	@NotEmpty(message = "{pl.marekhacieja.model.Book.type.NotEmpty}")
	@Column(name = "book_type")
	private String type;

	@NotEmpty(message = "{pl.marekhacieja.model.Book.publisher.NotEmpty}")
	@Column(name = "publisher")
	private String publisher;

	@NotEmpty(message = "{pl.marekhacieja.model.Book.price.NotEmpty}")
	@Min(value = 1, message = "{pl.marekhacieja.model.price.age.Min}")
	@Column(name = "price", scale = 2)
	private double price;

	@NotEmpty(message = "{pl.marekhacieja.model.Book.publisher.NotEmpty}")
	@Column(name = "picture_source")
	private String picture;

	@ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
	private List<Order> orders;

	public Book() {
	}

	public Book(String title, String author, String type, String publisher, double price, String picture) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.publisher = publisher;
		this.price = price;
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", type=" + type + ", publisher="
				+ publisher + ", price=" + price + ", orders=" + orders + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return Double.compare(book.price, price) == 0 &&
				Objects.equals(id, book.id) &&
				Objects.equals(title, book.title) &&
				Objects.equals(author, book.author) &&
				Objects.equals(type, book.type) &&
				Objects.equals(publisher, book.publisher) &&
				Objects.equals(picture, book.picture);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, author, type, publisher, price, picture);
	}
}
