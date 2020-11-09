package com.roulette.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "roulettes")

public class Roulette implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int number;

	private boolean color;

	@CreationTimestamp
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdRoulette;

	@UpdateTimestamp
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedRoulette;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Roulette() {
		super();
	}

	public Roulette(Long id, int number, boolean color, Date createdRoulette, Date updatedRoulette, User user) {
		super();
		this.id = id;
		this.number = number;
		this.color = color;
		this.createdRoulette = createdRoulette;
		this.updatedRoulette = updatedRoulette;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public Date getCreatedRoulette() {
		return createdRoulette;
	}

	public void setCreatedRoulette(Date createdRoulette) {
		this.createdRoulette = createdRoulette;
	}

	public Date getUpdatedRoulette() {
		return updatedRoulette;
	}

	public void setUpdatedRoulette(Date updatedRoulette) {
		this.updatedRoulette = updatedRoulette;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Roulette [id=" + id + ", number=" + number + ", color=" + color + ", createdRoulette=" + createdRoulette
				+ ", updatedRoulette=" + updatedRoulette + ", user=" + user + "]";
	}

}
