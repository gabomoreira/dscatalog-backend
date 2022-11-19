package com.gabosm.dscatalog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabosm.dscatalog.dto.ProductDTO;
import com.gabosm.dscatalog.entities.Product;
import com.gabosm.dscatalog.repositories.ProductRepository;
import com.gabosm.dscatalog.services.exceptions.DatabaseException;
import com.gabosm.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
		Page<Product> products = repository.findAll(pageRequest);
		return products.map(x -> new ProductDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDTO(product, product.getCategories());
	}
	
	@Transactional(readOnly = true)
	public ProductDTO insert(ProductDTO dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDesciption());
		product.setImgUrl(dto.getImgUrl());
		product.setDate(dto.getDate());
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	@Transactional(readOnly = true)
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product product = repository.getReferenceById(id);
			product.setName(dto.getName());
			product.setPrice(dto.getPrice());
			product.setDescription(dto.getDesciption());
			product.setImgUrl(dto.getImgUrl());
			product.setDate(dto.getDate());
			product = repository.save(product);
			return new ProductDTO(product);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+ id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+ id);
		} catch (EmptyResultDataAccessException e) {
			throw new DatabaseException("Integration violeded");
		}
	}
}
