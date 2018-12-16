package com.myretail.business.myRetailApp.service;

import com.myretail.business.myRetailApp.constants.Messages;
import com.myretail.business.myRetailApp.entities.Product;
import com.myretail.business.myRetailApp.exception.ProductNotFoundException;
import com.myretail.business.myRetailApp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }


    public String saveProduct(Product product) {
        product = productRepository.save(product);
         return product.getId();
    }

    public Product getProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        else {
            throw new ProductNotFoundException(Messages.PRODUCT_NOT_FOUND);
        }
    }

    public Product updateProduct(String id, Product product) {
        Product prod = productRepository.findById(id).get();
        if(product.getCurrent_price() != null)
            prod.setCurrent_price(product.getCurrent_price());
        if(product.getDescription() != null)
            prod.setDescription(product.getDescription());
        productRepository.save(prod);
        return prod;
    }

    public String removeProduct(String id) {

        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
        } else {
            throw new ProductNotFoundException(Messages.PRODUCT_NOT_FOUND);
        }

        return Messages.PRODUCT_DELETED_PASS;
    }
}
