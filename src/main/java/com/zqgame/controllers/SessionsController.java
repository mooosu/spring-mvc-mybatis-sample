package com.zqgame.controllers;

import com.zqgame.models.SignIn;
import com.zqgame.services.UserService;
import javax.validation.Valid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionsController {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired(required = true)
    UserService userService;

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("signIn", new SignIn());
        return "sessions/new";
    }

    @RequestMapping(value = "/sessions/create", method = RequestMethod.POST)
    public String create(@Valid SignIn signIn, BindingResult result) {
        if (result.hasErrors()) {
            return "sessions/new";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(signIn.getUsername(), signIn.getPassword());

        // ?Remember Me? built-in, just do this
        // TODO: Make this a user option instead of hard coded in.
        token.setRememberMe(true);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        }catch ( IncorrectCredentialsException ice) {
             result.reject("mismatch.signIn.password"); 
            //password didn't match, try again?
        } catch (AuthenticationException ae) {
            logger.info("Auth Failed:" + ae.getMessage());
        }
        boolean a = currentUser.hasRole("Test");
        if (currentUser.isAuthenticated()) {
            return "redirect:/";
        }
        return "sessions/new";
    }
}
