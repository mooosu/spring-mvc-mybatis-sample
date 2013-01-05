package com.zqgame.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignIn
{
	@NotNull
	@Size(min=5,max=50,message="{user.username.size}")
	private String username;
	@NotNull
	@Size(min=5,max=50,message="{user.password.size}")
	private String password;
	@NotNull
	@Size(min=4,max=4,message="{user.captcha.size}")
	private String captcha;

	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
