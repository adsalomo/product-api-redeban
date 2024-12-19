package com.redeban.product.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.redeban.product.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>, 
                                                 PagingAndSortingRepository<Product, Integer> {

}
