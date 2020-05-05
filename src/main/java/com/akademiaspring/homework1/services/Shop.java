package com.akademiaspring.homework1.services;

import com.akademiaspring.homework1.models.Price;
import com.akademiaspring.homework1.models.Product;


public interface Shop {
    Iterable<Product> getProducts();
    Product postProduct(Product product);
    void deleteProduct(Product product);
    void deleteProductById(Long id);
    Product putProduct(Long id, Product product);
    Price getPrice();
}
