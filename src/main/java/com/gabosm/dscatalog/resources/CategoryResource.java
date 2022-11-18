package com.gabosm.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabosm.dscatalog.entities.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping()
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(1L, "Books"));
		categories.add(new Category(2L, "Eletronics"));
		
		return ResponseEntity.ok().body(categories);
	}
}
