package com.rachana.Task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rachana.Task.model.User;
import com.rachana.Task.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/users")
	public List<User> getUserList() {
		  List<User> user = repo.findAll();
		  return user;
	}
	@DeleteMapping("/delete/{id}")
	public void deleteData(@PathVariable Long id) {repo.deleteById(id);
	}
	
	
}
