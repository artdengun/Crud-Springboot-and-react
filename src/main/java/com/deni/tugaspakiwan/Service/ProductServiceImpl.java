/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deni.tugaspakiwan.Service;

import com.deni.tugaspakiwan.model.Product;
import com.deni.tugaspakiwan.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chocolate
 */
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository productrepository;
    
    @Override
    public List<Product> findAllProduct() {
        return productrepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        Product product = productrepository.findById(id).orElse(new Product());
        
        return product;
    }

    @Override
    public Product saveorUpdateProduct(Product product) {
        return productrepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productrepository.findById(id).orElse(new Product());
        productrepository.delete(product);
    }
    
}
