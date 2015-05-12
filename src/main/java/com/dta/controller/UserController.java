package com.dta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dta.domain.Utilisateur;
import com.dta.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/{login}")
	@ResponseBody
	public UserJson getUser(@PathVariable("login") String login) {
		Utilisateur result = userService.find(login);
		return new UserJson(result);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createUser(@RequestBody Utilisateur user) {
		userService.create(user);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
	}
}
