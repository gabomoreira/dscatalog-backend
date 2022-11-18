package com.gabosm.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabosm.dscatalog.dto.CategoryDTO;
import com.gabosm.dscatalog.entities.Category;
import com.gabosm.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> listCategory = repository.findAll();
	
		return listCategory.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

}
