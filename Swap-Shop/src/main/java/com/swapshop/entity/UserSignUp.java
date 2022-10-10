package com.swapshop.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USERDETAILS")
public class UserSignUp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String UserName;
	private String email;
	private String password;
	private Date dob;
	private String Gender;
	private String Address;
	private long PhNo;
	private String Status;
	private String City;
	private String State;
	private String Country;
	private int pincode;
	private String Role;
}
