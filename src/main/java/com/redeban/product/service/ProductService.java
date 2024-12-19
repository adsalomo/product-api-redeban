package com.redeban.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.redeban.product.data.CategoryRepository;
import com.redeban.product.data.ProductRepository;
import com.redeban.product.domain.Category;
import com.redeban.product.domain.Product;
import com.redeban.product.dto.request.PaginationRequest;
import com.redeban.product.util.Utils;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public Page<Product> getProducts(PaginationRequest paginationRequest) {
		return productRepository.findAll(PageRequest.of(paginationRequest.getFrom(), paginationRequest.getSize()));
	}
	
	public Product createProduct(Product product) {
		product.setCreationDate(Utils.nowTimestamp());
		product.setUpdateDate(Utils.nowTimestamp());
		
		if (product.getPrice() != null) {
			if (product.getPriceValidUntil() == null || product.getPriceValidUntil().isEmpty()) {
				throw new IllegalArgumentException("Price valid until is required");
			}
		} else {
			product.setPrice(product.getListPrice());
		}
		
		Category category = categoryRepository
				.findById(product.getCategoryId().getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid category"));
		
		product.setCategoryId(category);
		
		return productRepository.save(product);
	}
	
}
