package com.paul.userimport.portlet.model;

public class UserBean {
	long liferayUserId;
	String username;
	String email;
	String firstName;
	String lastName;
	String password;
	boolean male;
	

	public long getLiferayUserId() {
		return liferayUserId;
	}

	public void setLiferayUserId(long liferayUserId) {
		this.liferayUserId = liferayUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBean [liferayUserId=" + liferayUserId + ", username="
				+ username + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", male=" + male + ", password="
				+ password + "]";
	}

}
