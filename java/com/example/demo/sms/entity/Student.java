package com.example.demo.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name",nullable = false)
	@NotBlank(message = "First name is mandatory")
	@Size(min=5,max = 10, message ="First name must be a minimum 5 and maximum of 10 character")
	@Pattern(regexp ="^[a-zA-Z]+$", message = "First name must be string only")
	private String firstName;
	@Column(name = "last_name")
	@Size(max = 10, message ="Last name must be a maximum of 10 character")
	private String lastName;
	@Column(name = "email")
	@Email 
	@Pattern(regexp = "^[a-zA-Z0-9\\.]+@ing+\\.com$" )
//	
//	    @Pattern(regexp = "^[a-zA-Z0-9\\.]+@ing+\\.com$")
//	    @Pattern(regexp = "^[a-zA-Z0-9\\.]+@yahoo+\\.com$")
//	    @Pattern(regexp = "^[a-zA-Z0-9\\.]+@gmail+\\.com$")
//	    @Pattern(regexp = "^[a-zA-Z0-9\\.]+@cognizant+\\.com$")
//	    @Pattern(regexp = "^[a-zA-Z0-9\\.]+@Hotmail+\\.com$")

	private String email;
	@Column(name= "age")
	@Digits(integer = 3,fraction = 0)
	private Long age;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	public Student(Long id, String firstName, String lastName, String email, Long age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	
	public Student() {
		super();
	}
	
	

}
