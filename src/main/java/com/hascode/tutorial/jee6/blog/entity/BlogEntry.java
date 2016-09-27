package com.hascode.tutorial.jee6.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class BlogEntry implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue
	private Long				id;



	@NotNull
	@Size(min = 30, max = 4000)
	private String				description;

	
	@NotNull
	private Date				datetime;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@NotNull
	@Size(min = 10, max = 40)
	private String				author;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				created				= new Date();

	@PrePersist
	private void onCreate() {
		created = new Date();
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}




	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
