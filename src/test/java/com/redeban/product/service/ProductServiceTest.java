package com.redeban.product.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.redeban.product.data.CategoryRepository;
import com.redeban.product.data.ProductRepository;
import com.redeban.product.domain.Category;
import com.redeban.product.domain.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private CategoryRepository categoryRepository;

	@Test
	public void createProduct() throws Exception {		
		Product product = getProduct();
		product.setId(1);
		
		Category category = getCategory();
		
		when(productRepository.save(any(Product.class))).thenReturn(product);
		when(categoryRepository.findById(any(Integer.class))).thenReturn(Optional.of(category));
		
		Product newProduct = getProduct();
		
		newProduct = productService.createProduct(newProduct);
		
		Assert.isTrue(newProduct.getId() == 1, "");
	}
	
	private Product getProduct() {
		Product product = new Product();
		product.setName("Test");
		product.setListPrice(300D);
		product.setCategoryId(getCategory());
		return product;
	}
	
	private Category getCategory() {
		Category category = new Category();
		category.setId(1);
		category.setName("Test");
		return category;
	}

}
