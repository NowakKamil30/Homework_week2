package com.akademiaspring.homework1.Controller;

import com.akademiaspring.homework1.models.Price;
import com.akademiaspring.homework1.models.Product;
import com.akademiaspring.homework1.services.Shop;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ProductController {

    final Shop shop;

    public ProductController(Shop shop) {
        this.shop = shop;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return shop.getProducts();
    }

    @PostMapping()
    public Product postProduct(@RequestBody Product product) {
        return shop.postProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable(name = "id") Long id) {
        shop.deleteProductById(id);
    }
    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        shop.deleteProduct(product);
    }

    @PutMapping("/{id}")
    public Product putProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) {
        return shop.putProduct(id, product);
    }

    @GetMapping("/price")
    public Price getPrice() {
        return shop.getPrice();
    }

}
