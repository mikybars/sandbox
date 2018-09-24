package com.inditex.rrhh.icmclcwb.model.service;

import com.inditex.rrhh.icmclcwb.api.dto.ProductDTO;
import com.inditex.rrhh.icmclcwb.api.service.ProductService;
import com.inditex.rrhh.icmclcwb.model.repository.Product;
import com.inditex.rrhh.icmclcwb.model.repository.ProductRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.inditex.rrhh.icmclcwb.model.mapper.ProductMapper;

import java.util.List;

/**
 * Implementación del servicio de producto
 */
@Service
@Validated
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private Logger logger;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductMapper productMapper;
    
    @Override
    public boolean modifyProduct(final ProductDTO product) {
        this.logger.debug("Modify product {}", product.getId());
        return this.productRepository.modifyProduct(this.productMapper.asProduct(product));
    }
    
    @Override
    public ProductDTO findProduct(final Integer id) {
        this.logger.debug("Find product {}", id);
        return this.productMapper.asProductDTO(this.productRepository.findProduct(id));
    }
    
    @Override
    public List<ProductDTO> findProducts(final List<Integer> ids) {
        this.logger.debug("Find products {}", ids);
        
        if (ids == null || ids.isEmpty()) {
            return this.productMapper.asProductDTOs(this.productRepository.findAllProducts());
        }
        return this.productMapper.asProductDTOs(this.productRepository.findProducts(ids));
        
    }
    
    @Override
    public Integer createProduct(final ProductDTO product) {
        this.logger.debug("Modify product with name {}", product.getName());
        return this.productRepository.createProduct(this.productMapper.asProduct(product));
        
    }
    
    @Override
    public boolean deleteProduct(final Integer id) {
        this.logger.debug("Delete product {}", id);
        return this.productRepository.deleteProduct(id);
    }
    
    @Override
    public Long countProducts() {
        this.logger.debug("Count product");
        return this.productRepository.count();
    }
    
}
