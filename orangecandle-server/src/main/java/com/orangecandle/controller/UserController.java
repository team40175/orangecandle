package com.orangecandle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orangecandle.domain.User;
import com.orangecandle.service.UserService;

@Controller// Spring MVC Controller
@RequestMapping(UserController.URL)

public class UserController {
	static final String URL = "/user";
	private UserService UserService;
	@RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addUserPage() {
	  ModelAndView modelAndView = new ModelAndView("User-add");
	  modelAndView.addObject("user", new User());
	  return modelAndView;
	 }
	@RequestMapping(value="/add", method=RequestMethod.POST)
	 public ModelAndView addingUser(@ModelAttribute User User) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  UserService.addUser(User);
	  String message = "User was successfully added.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
	 
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	 public ModelAndView edditingUser(@ModelAttribute User User, @PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  UserService.updateUser(User);
	  String message = "User was successfully edited.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
	  
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView deleteUser(@PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  UserService.removeUser(id);
	  String message = "User was successfully deleted.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
}
