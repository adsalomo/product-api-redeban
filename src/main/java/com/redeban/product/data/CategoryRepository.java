package com.redeban.product.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redeban.product.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
