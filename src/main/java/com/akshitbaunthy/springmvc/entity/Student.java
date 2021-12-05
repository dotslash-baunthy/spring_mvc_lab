package com.akshitbaunthy.springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Department")
    private String department;

    @Column(name = "Country")
    private String country;

    public Student(String name, String department, String country) {
        super();
        this.name = name;
        this.department = department;
        this.country = country;
    }
    
    public Student() {
    	super();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
