package com.gabosm.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabosm.dscatalog.dto.CategoryDTO;
import com.gabosm.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> categories = service.findAll();
		
		return ResponseEntity.ok().body(categories);
	}
}
