/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deni.tugaspakiwan.Controller;

import com.deni.tugaspakiwan.Service.ProductService;
import com.deni.tugaspakiwan.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chocolate
 */

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        
        return new ResponseEntity<>(productService.findAllProduct(),
               HttpStatus.OK
        );
    }
    
    @PostMapping
    public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product) {
        return new ResponseEntity<>(productService.saveorUpdateProduct(product), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id) throws Exception{
        
    return new ResponseEntity<Product>(productService.findProductById(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "delete sukses";
    }
}