package com.redeban.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redeban.product.converter.ProductConverter;
import com.redeban.product.domain.Product;
import com.redeban.product.dto.product.ProductDTO;
import com.redeban.product.dto.request.PaginationRequest;
import com.redeban.product.service.ProductService;
import com.redeban.product.util.HttpUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Product", description = "The Product Api")
@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

	private final ProductService productService;
	private final ProductConverter productConverter;
	
	private ProductController(ProductService productService, ProductConverter productConverter) {
		this.productService = productService;
		this.productConverter = productConverter;
	}
	
	@Operation(
            summary = "Create new product",
            description = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
	@PostMapping
	public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
		Product product = productService.createProduct(productConverter.convert(productDTO));
		return productConverter.convert(product);
	}
	
	@Operation(
            summary = "Fetch all products",
            description = "Fetches all product entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
	@GetMapping
	public List<ProductDTO> getProducts(@Valid PaginationRequest paginationRequest) {
		Page<Product> page = productService.getProducts(paginationRequest);
		
		HttpUtil.setHeaderTotalCountResponse(String.valueOf(page.getTotalElements()));
		
		return page.getContent()
				.stream().map(p -> productConverter.convert(p))
				.collect(Collectors.toList());
	}
	
}
