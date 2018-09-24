package com.inditex.rrhh.icmclcwb.model.repository;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    
    private static final String PRODUCT_PREFIX = "PRODUCT ";
    private final AtomicInteger keyGenerator;
    private final Map<Integer, Product> dataMap;
    
    public ProductRepositoryImpl() {
        this.keyGenerator = new AtomicInteger(1);
        this.dataMap = new ConcurrentHashMap<>();
        Product value = generateProduct(PRODUCT_PREFIX + this.keyGenerator.get());
        this.dataMap.put(value.getId(), value);
        value = generateProduct(PRODUCT_PREFIX + this.keyGenerator.get());
        this.dataMap.put(value.getId(), value);
        value = generateProduct(PRODUCT_PREFIX + this.keyGenerator.get());
        this.dataMap.put(value.getId(), value);
        value = generateProduct(PRODUCT_PREFIX + this.keyGenerator.get());
        this.dataMap.put(value.getId(), value);
        value = generateProduct(PRODUCT_PREFIX + this.keyGenerator.get());
        this.dataMap.put(value.getId(), value);
    }
    
    private Product generateProduct(final String name) {
        final Product value = new Product();
        value.setId(this.keyGenerator.getAndIncrement());
        value.setName(name);
        return value;
    }
    
    @Override
    public boolean modifyProduct(final Product product) {
        Validate.notNull(product.getId());
        return this.dataMap.put(product.getId(), product) != null;
    }
    
    @Override
    public Integer createProduct(final Product product) {
        product.setId(this.keyGenerator.getAndIncrement());
        this.dataMap.put(product.getId(), product);
        return product.getId();
    }
    
    @Override
    public boolean deleteProduct(final Integer id) {
        Validate.notNull(id);
        return this.dataMap.remove(id) != null;
        
    }
    
    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(this.dataMap.values());
        
    }
    
    @Override
    public List<Product> findProducts(final List<Integer> ids) {
        final List<Product> result = new ArrayList<>();
        for (final Integer id : ids) {
            result.add(findProduct(id));
        }
        return result;
    }
    
    @Override
    public Product findProduct(final Integer id) {
        if (id == null) {
            return null;
        }
        return this.dataMap.get(id);
    }
    
    @Override
    public Long count() {
        return Long.valueOf(this.dataMap.size());
    }
    
}
