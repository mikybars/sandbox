package com.inditex.rrhh.icmclcwb.api.service;

import com.inditex.rrhh.icmclcwb.api.dto.ProductDTO;

import javax.validation.Valid;
import java.util.List;

/**
 * Interfaz del servicio de producto
 */
public interface ProductService {
    
    Integer createProduct(@Valid final ProductDTO product);
    
    boolean deleteProduct(final Integer id);
    
    boolean modifyProduct(@Valid final ProductDTO product);
    
    ProductDTO findProduct(final Integer id);
    
    List<ProductDTO> findProducts(final List<Integer> ids);
    
    Long countProducts();
    
}
