package com.myretail.business.myRetailApp.service;

import com.myretail.business.myRetailApp.entities.Price;
import com.myretail.business.myRetailApp.entities.Product;
import com.myretail.business.myRetailApp.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void getAllProduct() {

        Product headphone = new Product();
        Price price = new Price();
        price.setCurrency_code("USD");
        price.setValue(23);
        headphone.setDescription("Headphone");
        headphone.setCurrent_price(price);

        Product tv = new Product();
        Price tvPrice = new Price();
        tvPrice.setCurrency_code("USD");
        tvPrice.setValue(230);
        tv.setDescription("TV ");
        tv.setCurrent_price(tvPrice);

        List<Product> productList = Arrays.asList(headphone,tv);
        when(productRepository.findAll()).thenReturn(productList);
        Assert.assertEquals(productList, productService.getAllProduct());
    }

    @Test
    public void saveProduct() {
        Product headphone = new Product();
        Price price = new Price();
        price.setCurrency_code("USD");
        price.setValue(23);
        headphone.setDescription("Headphone");
        headphone.setCurrent_price(price);
        when(productRepository.save(headphone)).thenReturn(headphone);
        Assert.assertEquals(headphone.getId(), productService.saveProduct(headphone));
    }

    @Test
    public void getProduct() {
        Product headphone = new Product();
        Price price = new Price();
        price.setCurrency_code("USD");
        price.setValue(23);
        headphone.setId("123");
        headphone.setDescription("Headphone");
        headphone.setCurrent_price(price);
        Optional<Product> optional =  Optional.of(headphone);
        when(productRepository.findById("123")).thenReturn(optional);
        Assert.assertEquals(headphone, productService.getProduct("123"));
    }

    @Test
    public void updateProduct() {
        Product headphone = new Product();
        Price price = new Price();
        price.setCurrency_code("USD");
        price.setValue(23);
        headphone.setDescription("Headphone");
        headphone.setCurrent_price(price);
        Optional<Product> optional =  Optional.of(headphone);
        when(productRepository.findById("123")).thenReturn(optional);
        Assert.assertEquals(headphone, productService.updateProduct("123", headphone));
    }

    @Test
    public void removeProduct() {
        Product headphone = new Product();
        Price price = new Price();
        price.setCurrency_code("USD");
        price.setValue(23);
        headphone.setDescription("Headphone");
        headphone.setCurrent_price(price);
        Optional<Product> optional =  Optional.of(headphone);
        when(productRepository.findById("123")).thenReturn(optional);
        Assert.assertEquals(headphone.getId(), productService.removeProduct("123"));
    }
}