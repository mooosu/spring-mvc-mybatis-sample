package com.zqgame.models;

import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private Integer id;
    @NotNull
    @Size(min = 5, max = 50, message = "{user.username.size}")
    private String username;
    @NotNull
    @Size(min = 5, max = 50, message = "{user.email.size}")
    private String email;
    @NotNull
    @Size(min = 5, max = 50, message = "{user.password.size}")
    private String password;
    @NotNull
    @Size(min = 5, max = 50, message = "{user.confirmation_password.size}")
    private String confirmation_password;
    @NotNull
    @Size(min = 4, max = 4, message = "{user.captcha.size}")
    private String captcha;
    private String salt;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getConfirmation_password() {
        return confirmation_password;
    }

    public void setConfirmation_password(String confirmation_password) {
        this.confirmation_password = confirmation_password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }
}
