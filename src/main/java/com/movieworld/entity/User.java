package com.movieworld.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	private String userId;
	
	private int id;

	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;
	
	private String firstname;
	
	private String lastname;
	
//	@Column(name="STATE", nullable=false)
//	private String state=State.ACTIVE.getState();
//
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "APP_USER_USER_PROFILE", 
//             joinColumns = { @JoinColumn(name = "USER_ID") }, 
//             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
//	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	public User() {
		this.userId = UUID.randomUUID().toString();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	@Column(unique= true)
	private String email;
	
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}

//	public Set<UserProfile> getUserProfiles() {
//		return userProfiles;
//	}
//
//	public void setUserProfiles(Set<UserProfile> userProfiles) {
//		this.userProfiles = userProfiles;
//	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof User))
//			return false;
//		User other = (User) obj;
//		if (id != other.id)
//			return false;
//		if (ssoId == null) {
//			if (other.ssoId != null)
//				return false;
//		} else if (!ssoId.equals(other.ssoId))
//			return false;
//		return true;
//	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
//				+ ", firstName=" + firstname + ", lastName=" + lastname
//				+ ", email=" + email + ", state=" + state + ", userProfiles=" + userProfiles +"]";
//	}


}
