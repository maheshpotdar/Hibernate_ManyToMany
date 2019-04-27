package com.mahesh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cid")
	private int cid;

	@Column(name = "cname")
	private String cname;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	// 5 car cha owner 1 cha ahe.
	@ElementCollection
	@ManyToMany
	private List<Person> person;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + "]";
	}
}
