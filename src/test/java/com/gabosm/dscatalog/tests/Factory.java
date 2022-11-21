package com.gabosm.dscatalog.tests;

import java.time.Instant;

import com.gabosm.dscatalog.dto.ProductDTO;
import com.gabosm.dscatalog.entities.Category;
import com.gabosm.dscatalog.entities.Product;

public class Factory {
	
	public static Product createProduct() {
		Product product = new Product(1L, "Soccer Ball Robot", "It is a soccer ball and also a robot, it is very crazy.", 239.99, "imgurl.imgurl", Instant.now());
		product.getCategories().add(new Category(1L,"Computers"));
		product.getCategories().add(new Category(2L,"Eletronics"));
		return product;  
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
		
	}

}
