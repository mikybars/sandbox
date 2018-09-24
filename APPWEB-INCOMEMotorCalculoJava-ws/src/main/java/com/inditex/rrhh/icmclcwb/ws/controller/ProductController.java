package com.inditex.rrhh.icmclcwb.ws.controller;


import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.dto.ProductDTO;
import com.inditex.rrhh.icmclcwb.api.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/**
 * Controlador REST para exponer operaciones de ProductService.
 * <p>
 * Es necesario que todos los controladores REST tengan a nivel de clase la anotación @Api, con la declaración del
 * atributo {code authorizations} tal cuál está en este ejemplo. Además, es necesario que cada método expuesto este
 * anotado con @ApiOperation
 * </p>
 * <p>
 * En este caso no vamos a activar la validacion dado que el controlador y el servicio usan el mismo DTO y se esta
 * haciendo la validacion en el servicio. Si fuese otro DTO si seria necesario validar en este punto.
 * </p>
 */

@Validated
@RestController
@RequestMapping(path = "/product")
@Api(authorizations = @Authorization(
        value = "ItxApiKey",
        scopes = {}
        ))
public class ProductController {


    /**
     * Bean del servicio
     */
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation("Find all products")
    public List<ProductDTO> findAll() {

        List<ProductDTO> products = this.productService.findProducts(Collections.emptyList());

        return products ;
    }

    @GetMapping(path = "/count/")
    @ApiOperation("Get the number of products")
    public Long count() {
        return this.productService.countProducts();
    }

    @GetMapping(path = "{id}")
    @ApiOperation("Find product by id")
    public ProductDTO finById(@PathVariable final Integer id) {
        return this.productService.findProduct(id);
    }

    @GetMapping(path = "/findByIdSecure/{id}")
    @ApiOperation("Find product by id from given rol. The user should have a rol TESTSECURITY")
    @PreAuthorize("hasAuthority('admin')")
    public ProductDTO findByIdSecure(@PathVariable final Integer id) {
        return this.productService.findProduct(id);
    }

    @PostMapping
    @ApiOperation("Insert a new product")
    public @Valid ProductDTO insert(@Valid @RequestBody final ProductDTO product) {
        final Integer id = this.productService.createProduct(product);
        product.setId(id);
        return product;
    }

    @PutMapping(path = "{id}")
    @ApiOperation("Modify an existing product")
    public ProductDTO modify(@PathVariable final Integer id, @RequestBody final ProductDTO product) {
        product.setId(id);
        if (this.productService.modifyProduct(product)) {
            return finById(product.getId());
        }
        return product;
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation("Remove a product by id")
    public Integer delete(@PathVariable final Integer id) {
        this.productService.deleteProduct(id);
        return id;
    }

}