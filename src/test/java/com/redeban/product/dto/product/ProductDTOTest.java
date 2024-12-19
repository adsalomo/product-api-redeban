package com.redeban.product.dto.product;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductDTOTest {

	@Test
	public void validateProductDTO() {
		ProductDTO productDTO = getProductDTO();
		
		Assert.isTrue(productDTO.getId() > 0, "");
		Assert.notNull(productDTO.getName(), "");
		Assert.notNull(productDTO.getCategoryId(), "");
		Assert.notNull(productDTO.getListPrice(), "");
		Assert.notNull(productDTO.getPrice(), "");
		Assert.notNull(productDTO.getPriceValidUntil(), "");
		Assert.notNull(productDTO.getCreationDate(), "");
		Assert.notNull(productDTO.getUpdateDate(), "");
	}
	
	private ProductDTO getProductDTO() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(1);
		productDTO.setName("Test");
		productDTO.setCategoryId(new CategoryDTO());
		productDTO.setListPrice(0D);
		productDTO.setPrice(0D);
		productDTO.setPriceValidUntil("2024-12-31");
		productDTO.setCreationDate("2024-12-31T22:30:20");
		productDTO.setUpdateDate("2024-12-31T22:30:20");
		return productDTO;
	}
	
}
