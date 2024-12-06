package com.task.task.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.task.task.entity.Product;
import com.task.task.service.productService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class productController {

    @Autowired
    private productService productService;

    @PostMapping("/addprod")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProductById(id, product);
    }

    @GetMapping
    public List<Product> getPaginatedProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return productService.getProductwithPagination(page, size);
    }
}
