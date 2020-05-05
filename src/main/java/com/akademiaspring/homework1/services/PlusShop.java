package com.akademiaspring.homework1.services;

import com.akademiaspring.homework1.models.Price;
import com.akademiaspring.homework1.models.Product;
import com.akademiaspring.homework1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("Plus")
public class PlusShop implements Shop{
    private final ProductRepository productRepository;
    @Value("${vat}")
    private int vat;

    @Autowired
    public PlusShop(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
    @Override
    public Product postProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public Product putProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Price getPrice() {
        final BigDecimal[] price = {BigDecimal.valueOf(0)};
        Iterable<Product> productIterable = getProducts();
        productIterable.forEach(product -> price[0] = price[0].add(product.getPrice()));
        return new Price(price[0].add(price[0].multiply(BigDecimal.valueOf(vat/100.0))));
    }
}
