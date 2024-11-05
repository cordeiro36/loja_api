package com.loja.pedidos.domain.product;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(RequestProduct request) {
        Product newProduct = new Product(request);
        return repository.save(newProduct);
    }

    public List<Product> getAllProducts() {
        return repository.findAllByActiveTrue();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado."));
    }

    public Product updateProduct(Long id, RequestProduct request) {
        Product product = getProductById(id);
        product.setName(request.getName());
        product.setPrice_in_cents(request.getPrice_in_cents());
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        product.setActive(false);
        repository.save(product);
    }
}