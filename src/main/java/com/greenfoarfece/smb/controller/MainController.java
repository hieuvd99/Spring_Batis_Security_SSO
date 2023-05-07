package com.greenfoarfece.smb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.greenfoarfece.smb.domain.User;
import com.greenfoarfece.smb.service.PersonService;
import com.greenfoarfece.smb.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("personService")
	private PersonService personSvc;

	@RequestMapping("/")
	public String home() {
		return "homepage";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "loginPage";
	}
	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public String getHome(Model model) {
		model.addAttribute("users", userService.getUser());
		System.out.println(" userService.getUser() == "+userService.getUser());
		return "index";
	}

	@RequestMapping(value="/admin/saveUser",method=RequestMethod.POST)
	public String insertUser(@ModelAttribute("user") User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userService.insertUser(user);
		return "redirect:/admin/user";
	}

	@RequestMapping("/admin/insertUser")
	public String add(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "adminAddUser";
	}

	@RequestMapping(value="insertMutipleUser",method=RequestMethod.POST)
	public String inserMutipleUser( @RequestBody List<User> userList) {
		userService.insertMutipleUser(userList);
		return "redirect:/user";
	}

	@RequestMapping("/admin/editUser")
	public String edituser(@RequestParam long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "adminEditUser";
	}

	@RequestMapping(value="/admin/updateUser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userService.updateUser(user);
		return "redirect:/admin/user";
	}

	@RequestMapping(value="/admin/deleteUser",method=RequestMethod.GET)
	public String deleteUser(@RequestParam long id) {
		userService.deleteUser(id);
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getPerson(Model model) {
		model.addAttribute("person", personSvc.getPerson());
		return "index2";
	}
}
