package com.roulette.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	private String names;

	@NotBlank(message = "Surname is mandatory")
	private String surnames;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Must be a properly formatted email address")
	private String email;

	@CreationTimestamp
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdUser;

	@UpdateTimestamp
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedUser;

	@JsonManagedReference
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Roulette roulette;

	public User() {
		super();
	}

	public User(Long id, @NotBlank(message = "Name is mandatory") String names,
			@NotBlank(message = "Name is mandatory") String surnames,
			@NotBlank(message = "Name is mandatory") @Email String email, Date createdUser, Date updatedUser,
			Roulette roulette) {
		super();
		this.id = id;
		this.names = names;
		this.surnames = surnames;
		this.email = email;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
		this.roulette = roulette;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Date createdUser) {
		this.createdUser = createdUser;
	}

	public Date getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(Date updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Roulette getRoulette() {
		return roulette;
	}

	public void setRoulette(Roulette roulette) {
		this.roulette = roulette;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", names=" + names + ", surnames=" + surnames + ", email=" + email + ", createdUser="
				+ createdUser + ", updatedUser=" + updatedUser + ", roulette=" + roulette + "]";
	}

}
