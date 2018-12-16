package com.myretail.business.myRetailApp.repositories;

import com.myretail.business.myRetailApp.entities.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, String> {
}
