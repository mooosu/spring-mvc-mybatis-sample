/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.services;

import com.zqgame.models.Blog;
import com.zqgame.mappers.BlogMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author roscus
 */
public class BlogService {
    @Autowired(required = true)
    private BlogMapper blogMapper;
    public void setBlogMapper(BlogMapper blogMapper) {
            this.blogMapper = blogMapper;
    }
	public Blog findById(int id )
	{
		return blogMapper.findById(id);
	}
	public int save(Blog blog )
	{
		return blogMapper.save(blog);
	}
    public List<Blog> findAllBlogs()
    {
        return blogMapper.findAllBlogs(null);
    }
}
