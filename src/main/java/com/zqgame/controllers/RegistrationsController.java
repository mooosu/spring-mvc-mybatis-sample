package com.zqgame.controllers;

import com.zqgame.models.User;
import com.zqgame.services.UserService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationsController{
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired(required = true )
	UserService userService;

	@RequestMapping(value="/sign_up",method=RequestMethod.GET)
	public String newForm(Model model)
	{
		model.addAttribute("user",new User());
		return "registrations/new";
	}

	@RequestMapping(value="/registrations/create",method=RequestMethod.POST)
	public String create(@Valid User user,BindingResult result,Model model)
	{
		if( result.hasErrors()){
			return "registrations/new";
		}

		User u = this.userService.create(user);         
		logger.info("user created");
		model.addAttribute("user", u);
		return "redirect:/";
	}

}
