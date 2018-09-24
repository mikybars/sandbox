package com.inditex.rrhh.icmclcwb.model.repository;

import java.util.List;

public interface ProductRepository {
    
    List<Product> findProducts(final List<Integer> ids);
    
    List<Product> findAllProducts();
    
    boolean deleteProduct(final Integer id);
    
    Integer createProduct(final Product product);
    
    boolean modifyProduct(final Product product);
    
    Product findProduct(Integer id);
    
    Long count();
    
}
