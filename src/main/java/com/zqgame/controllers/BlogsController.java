package com.zqgame.controllers;

import com.zqgame.mappers.BlogMapper;
import com.zqgame.models.Blog;
import com.zqgame.common.ResourceNotFoundException;

import org.noo.pagination.annotation.Paging;
import org.noo.pagination.page.PageContext;
import org.noo.pagination.page.Page;
import org.noo.pagination.page.Pagination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogsController {
	private static final Logger LOG = LoggerFactory.getLogger(BlogsController.class);
	@Resource(name="blogMapper")
	private BlogMapper blogMapper;

	@RequestMapping(value="/blogs",method=RequestMethod.GET)
	public String index(Model model)
	{
		Pagination pager = PageContext.getPageContext();
		List<Blog> blogs = blogMapper.findAllBlogs(pager);
		model.addAttribute("blogs",blogs);
		model.addAttribute("pager",pager);
		return "blogs/index";
	}
	@RequestMapping(value="/blogs/new",method=RequestMethod.GET)
	public String newForm(Model model)
	{
		model.addAttribute(new Blog());
		return "blogs/new";
	}

	@RequestMapping(value="/blogs/create",method=RequestMethod.POST)
	public String create(@Valid Blog blog,BindingResult result)
	{
		if( result.hasErrors()){
			return "blogs/new";
		}
		blogMapper.save(blog);
		return "redirect:/blogs";
	}
	@RequestMapping(value="/blogs/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id, Model model)
	{
		Blog blog = blogMapper.findById(id);
		if( blog == null ){
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(blog);
		return "blogs/show";
	}
}

