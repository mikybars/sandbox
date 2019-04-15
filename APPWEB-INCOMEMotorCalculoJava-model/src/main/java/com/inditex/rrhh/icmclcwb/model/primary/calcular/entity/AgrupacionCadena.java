package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "AGRUPACION_CADENA")
@Data
public class AgrupacionCadena {

    @Id
    @Column(name = "ID_AGRUPACION_CADENA")
    private Long id;
    
    @NotBlank
    @Column(name = "ID_AGRUPACION")
    private Long idAgrupacion;
    
    @NotBlank
    @Column(name = "ID_CADENA")
    private String idCadena;
    
}
