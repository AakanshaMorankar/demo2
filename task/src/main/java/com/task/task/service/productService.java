package com.task.task.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.task.entity.Product;
import com.task.task.repository.productRepository;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public List<Product> getProductwithPagination(int offset, int pageSize) {
        int start = offset * pageSize + 1;  
        int end = start + pageSize - 1;
        return productRepository.findProductWithPagination(start, end);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProductById(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());
        return productRepository.save(existingProduct);
    }
}
