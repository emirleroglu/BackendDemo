package com.emirleroglu.backenddemo.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ApiModel(value = "User api documentation", description = "This api model is the entity of the user class.")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Unique id field of user object")
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
    @ApiModelProperty(value = "education email field of user object")
    private String email;
    @Column(name = "password", nullable = false)
    @ApiModelProperty(name = "password field of user object")
    private String password;
    @Column(name = "isactive", nullable = false)
    @ApiModelProperty(name = "activate filed of user object")
    private Boolean isActive;


    public User(String email, String password, Boolean isActive) {

        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

