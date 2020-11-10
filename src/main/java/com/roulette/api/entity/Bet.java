package com.roulette.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "bets")
public class Bet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Value field cannot be blank")
	@Min(value = 1, message = "Value min. $1")
	@Max(value = 36000, message = "Value max. $36.000")
	private double value;

	@CreationTimestamp
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdBet;

	@UpdateTimestamp
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedBet;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Bet() {
		super();
	}

	
	public Bet(Long id,
			@NotBlank(message = "Value field cannot be blank") @Min(value = 1, message = "Value min. $1") @Max(value = 36000, message = "Value max. $36.000") double value,
			Date createdBet, Date updatedBet, User user) {
		super();
		this.id = id;
		this.value = value;
		this.createdBet = createdBet;
		this.updatedBet = updatedBet;
		this.user = user;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public double getValue() {
		return value;
	}



	public void setValue(double value) {
		this.value = value;
	}



	public Date getCreatedBet() {
		return createdBet;
	}



	public void setCreatedBet(Date createdBet) {
		this.createdBet = createdBet;
	}



	public Date getUpdatedBet() {
		return updatedBet;
	}



	public void setUpdatedBet(Date updatedBet) {
		this.updatedBet = updatedBet;
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
		return "Bet [id=" + id + ", value=" + value + ", createdBet=" + createdBet + ", updatedBet=" + updatedBet
				+ ", user=" + user + "]";
	}

	

}
