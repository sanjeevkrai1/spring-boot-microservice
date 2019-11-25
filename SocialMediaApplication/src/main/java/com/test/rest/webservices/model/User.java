package com.test.rest.webservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "users")
@ApiModel(description = "Complete details of Users")
public class User extends AbstractEntity {

	private static final long serialVersionUID = -1067357070052975358L;

	@NotNull
	@Size(max = 150)
	@Column(name = "user_f_name")

	private String fName;

	@Column(name = "user_m_name")
	@Size(max = 150)
	private String mName;

	@Column(name = "user_l_name")
	@Size(max = 150)
	private String lName;

	@NotNull
	@Size(max = 150)
	@Column(name = "email")
	private String email;

	@NotNull
	@Size(max = 150)
	@Column(name = "password")
	private String password;

	@NotNull
	@Size(max = 150)
	@Column(name = "user_id", unique = true)
	private String userId;

	@NotNull
	@Size(max = 150)
	@Column(name = "gender")
	private String gender;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("User [fName=%s, mName=%s, lName=%s, email=%s, password=%s, userId=%s, gender=%s]", fName,
				mName, lName, email, password, userId, gender);
	}
}
