package com.gabosm.dscatalog.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.gabosm.dscatalog.dto.ProductDTO;
import com.gabosm.dscatalog.services.ProductService;
import com.gabosm.dscatalog.tests.Factory;

@WebMvcTest
public class ProductResourceTests {

	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService service;
	
	private ProductDTO productDTO;
	private PageImpl<ProductDTO> page;
	
	@BeforeEach
	void setUp() throws Exception {
		
		productDTO = Factory.createProductDTO();
		page = new PageImpl<>(List.of(productDTO));
		
		when(service.findAllPaged(any())).thenReturn(page);		
	}
	
	@Test
	public void findAllPagedShouldReturnPage() throws Exception {
		
		mockMvc.perform(get("/products")
				.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
	}
}


















