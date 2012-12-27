package com.zqgame.models;

import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Blog{

	private int id;
	@NotNull
	@Size(min=5,max=50,message="{blog.title.size}")
	private String title;
	@NotNull
	private String content;
	private String comment;
	@NotNull
	private java.sql.Timestamp created_at;
	private java.sql.Timestamp updated_at;

	public int getId()
	{
		return id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getComment()
	{
		return comment;
	}
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	public Timestamp getCreated_at()
	{
		return created_at;
	}
	public void setCreated_at(Timestamp created_at)
	{
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at()
	{
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at)
	{
		this.updated_at = updated_at;
	}
}
