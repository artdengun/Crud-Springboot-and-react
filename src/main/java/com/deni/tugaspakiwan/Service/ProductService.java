/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deni.tugaspakiwan.Service;

import java.util.List;
import com.deni.tugaspakiwan.model.Product;
/**
 *
 * @author chocolate
 */
public interface ProductService {
    List<Product> findAllProduct();
    
    Product findProductById(Long id);
    
    Product saveorUpdateProduct(Product product);
    
    void deleteProduct(Long id);
}
