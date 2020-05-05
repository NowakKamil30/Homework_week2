package com.akademiaspring.homework1.repositories;

import com.akademiaspring.homework1.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
