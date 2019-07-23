package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TIPO_POLITICA")
@Data
public class TipoPolitica {

    @Id
    @Column(name = "ID_TIPO_POLITICA")
    private Long id;

    @NotBlank
    @Column(name = "DESCRIPCION", length = /*TAMANO_DESC*/ 255, nullable = false)
    private String descripcion;

    @NotBlank
    @Column(name = "CODIGO", nullable = false)
    private String codigo;

}
