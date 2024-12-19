package com.redeban.product.converter;

import org.springframework.stereotype.Component;

import com.redeban.product.domain.Category;
import com.redeban.product.domain.Product;
import com.redeban.product.dto.product.CategoryDTO;
import com.redeban.product.dto.product.ProductDTO;

@Component
public class ProductConverter {

	public Product convert(ProductDTO productDTO) {
		Product product = new Product();
		
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setListPrice(productDTO.getListPrice());
		product.setPriceValidUntil(productDTO.getPriceValidUntil());
		
		Category category = new Category();
		category.setId(productDTO.getCategoryId().getId());
		category.setName(productDTO.getCategoryId().getName());
		
		product.setCategoryId(category);
		
		return product;
	}
	
	public ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setListPrice(product.getListPrice());
		productDTO.setPriceValidUntil(product.getPriceValidUntil());
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(product.getCategoryId().getId());
		categoryDTO.setName(product.getCategoryId().getName());
		
		productDTO.setCategoryId(categoryDTO);
		productDTO.setCreationDate(product.getCreationDate());
		productDTO.setUpdateDate(product.getUpdateDate());
		
		return productDTO;
	}
	
}
