package com.exacta.gastos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exacta.gastos.entity.Gasto;
import com.exacta.gastos.entity.Tag;
import com.exacta.gastos.repository.GastoRepository;
import com.exacta.gastos.repository.TagRepository;

@RestController
public class GastoController {

	@Autowired
	private GastoRepository gastoRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@GetMapping(value = "/gasto")
	public Iterable<Gasto> findAll() {
		return gastoRepository.findAll();
	}
	
	@GetMapping(value = "/gasto/{id}")
	public Optional<Gasto> findById(@PathVariable Long id) {
		return gastoRepository.findById(id);
	}
	
	@PostMapping(value = "/gasto")
	public Gasto create(@RequestBody Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	@PutMapping(value = "/gasto/{id}/tag")
	public ResponseEntity<Tag> addTagToGasto(@PathVariable Long id, @RequestBody Tag tag) {
		Optional<Gasto> gasto = findById(id);
		
		if (gasto.isPresent()) {
			tag.setGasto(gasto.get());
			return ResponseEntity.ok(tagRepository.save(tag));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
	
}
