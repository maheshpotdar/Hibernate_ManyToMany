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
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pid")
	private int pid;

	@Column(name = "pname")
	private String pname;

	// eka manasakade 5 car ahet.
	@ElementCollection
	@ManyToMany(mappedBy = "person")
	private List<Car> car;
	// mappedBy = "person" ye car tu third table tayar karu nako.
	// third table person tayar karude .

	// karan mapping annotation car kade pan ahe mag car mannar mi third table
	// car_person tayar karato.

	// person kade pan mapping @OneToMany annotation ahe so
	// person manar mi person_car tayar karnar

	// mapping nahi dila tar donhi table tayar karu shaktat.

	public Person(int pid, String pname, List<Car> car) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.car = car;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Person(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", car=" + car + "]";
	}

}
