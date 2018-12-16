package com.myretail.business.myRetailApp.controller;

import com.myretail.business.myRetailApp.entities.Product;
import com.myretail.business.myRetailApp.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    ProductService productService;

    @RequestMapping(method= RequestMethod.GET, value="/products")
    public Iterable<Product> product() {
        return productService.getAllProduct();
    }

    @RequestMapping(value="/products", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE,produces = MediaType.ALL_VALUE)
    public String save(@RequestBody Product product) {
       return productService.saveProduct(product);
    }

    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public Product show(@PathVariable String id) {
       return productService.getProduct(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}", consumes = MediaType.ALL_VALUE,produces = MediaType.ALL_VALUE)
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return  productService.updateProduct(id, product);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
    public String delete(@PathVariable String id) {
       return productService.removeProduct(id);
    }
}
