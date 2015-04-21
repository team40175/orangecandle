package com.orangecandle.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orangecandle.domain.Group;
import com.orangecandle.service.GroupService;
@Transactional
@Repository  // Spring DAO
@RequestMapping(GroupController.URL)
@Controller// Spring MVC Controller
public class GroupController {
	static final String URL = "/group";
	private GroupService groupService;
	@RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addGroupPage() {
	  ModelAndView modelAndView = new ModelAndView("Group-add");
	  modelAndView.addObject("Group", new Group());
	  return modelAndView;
	 }
	@RequestMapping(value="/add", method=RequestMethod.POST)
	 public ModelAndView addingGroup(@ModelAttribute Group group) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  groupService.addGroup(group);
	  String message = "Group was successfully added.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
	 
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	 public ModelAndView edditingGroup(@ModelAttribute Group Group, @PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  groupService.updateGroup(Group);
	  String message = "Group was successfully edited.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
	  
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView deleteGroup(@PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  groupService.removeGroup(id);
	  String message = "Group was successfully deleted.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
}
