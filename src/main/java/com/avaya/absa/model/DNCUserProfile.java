package com.avaya.absa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DNC_USER_PROFILE")
public class DNCUserProfile {
	
	private String userName="";
    private String userPassword="";
    private String firstName="";
    private String lastName="";
    
    public DNCUserProfile() {}
    
    public DNCUserProfile(String userName, String userPassword, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
    @Column(name = "USER_NAME", nullable = false)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name = "USER_PASSWORD", nullable = false)
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name = "FIRST_NAME", nullable = true)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "LAST_NAME", nullable = true)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
