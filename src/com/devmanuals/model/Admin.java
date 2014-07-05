package com.devmanuals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {
	private static final long serialVersionUID = -2571080121554112L;

	public Admin(){}

	@Id @GeneratedValue
	@Column(name = "ID")
	private long id;
	 
	@Column(name = "USERNAME",unique=true)
	private String username;
	 
	@Column(name = "PASSWORD")
	private String password;
	 
	@Column(name = "PRIV")
	private long priv;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPriv() {
		return priv;
	}

	public void setPriv(long priv) {
		this.priv = priv;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	 
}
