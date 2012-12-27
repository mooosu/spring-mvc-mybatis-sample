package com.zqgame.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User
{
	private Integer id;

	@NotNull
	@Size(min=5,max=50,message="{user.username.size}")
	private String username;

	@NotNull
	@Size(min=5,max=50,message="{user.password.size}")
	private String password;

	@NotNull
	@Size(min=5,max=50,message="{user.confirmation_password.size}")
	private String confirmation_password;

	@NotNull
	@Size(min=4,max=4,message="{user.captcha.size}")
	private String captcha;

	@NotNull
	@Size(min=4,max=4,message="{user.email.size}")
	private String email;
	private String salt;

	public Integer getId()
	{
		return id;
	}
	public void setId( Integer id )
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getConfirmationPassword()
	{
		return confirmation_password;
	}
	public void setConfirmationPassword(String confirmation_password)
	{
		this.confirmation_password = confirmation_password;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getSalt()
	{
		return salt;
	}
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	public String getCaptcha()
	{
		return captcha;
	}
	public void setCaptcha(String captcha )
	{
		this.captcha = captcha;
	}

}
