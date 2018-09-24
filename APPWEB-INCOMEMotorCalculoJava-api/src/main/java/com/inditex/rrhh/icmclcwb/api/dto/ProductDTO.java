package com.inditex.rrhh.icmclcwb.api.dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Clase que define un producto
 */
public class ProductDTO implements Serializable {
    
    private static final long serialVersionUID = -8476952044051615476L;
    
    private Integer id;
    
    @Size(max = 20)
    @NotEmpty
    private String name;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    /**
     * @return El nombre del producto
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @param name Nombre del producto
     */
    public void setName(final String name) {
        this.name = name;
    }
    
}
