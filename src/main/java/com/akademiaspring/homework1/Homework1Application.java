package com.akademiaspring.homework1;

import com.akademiaspring.homework1.models.Product;
import com.akademiaspring.homework1.services.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
public class Homework1Application {
    private final Shop shop;

    @Autowired
    public Homework1Application(Shop shop) {
        this.shop = shop;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework1Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadProduct() {
        for (int i = 0; i < 5; i++) {
            shop.postProduct(generateProduct());
        }
    }

    private Product generateProduct() {
        Product product = new Product();
        Random random = new Random();
        BigDecimal price = BigDecimal.valueOf(random.nextInt(251) + 50);
        int nameLength = random.nextInt(10) + 2;
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            name.append((char)(random.nextInt(25) + 97));
        }
        product.setPrice(price);
        product.setName(name.toString());
        return product;
    }
}
