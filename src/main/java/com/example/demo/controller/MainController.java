package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Users;
import com.example.demo.services.UsersServicesImpl;

@Controller
public class MainController {
	
	@Autowired
	private UsersServicesImpl service;
	
	@RequestMapping("/")
	public String index(Model model) {		
		model.addAttribute("users", "anand");
		return "index";
	}
	
	@RequestMapping("/listView")
	public String listViewI(Model model) {
		List<Users> urs = service.findAll();
		model.addAttribute("users", urs);		
		return "listView";
	}
	
	@RequestMapping("/newUser")
	public String newUser(Model model) {
		Users user = new Users();
	    model.addAttribute("user", user);
		return "newUser";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Users user, Model model) {
		service.save(user);
		return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("editUser");
	    Users user= service.get(id);
	    mav.addObject("user", user);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}

}
