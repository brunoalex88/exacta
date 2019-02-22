package com.exacta.gastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exacta.gastos.entity.Tag;
import com.exacta.gastos.repository.TagRepository;

@RestController
public class TagController {

	@Autowired
	private TagRepository tagRepository;
	
	@GetMapping(value = "/tag")
	public Iterable<Tag> findAll() {
		return tagRepository.findAll();
	}
	
	@PostMapping(value = "/tag")
	public Tag create(@RequestBody Tag tag) {
		return tagRepository.save(tag);
	}
	
}
