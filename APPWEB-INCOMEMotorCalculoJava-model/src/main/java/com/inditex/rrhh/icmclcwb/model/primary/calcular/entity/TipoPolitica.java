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
    @Column(name = "NOMBRE", length = /*TAMANO_NOMBRE*/ 128, nullable = false)
    private String nombre;

    @NotBlank
    @Column(name = "ICM_ID_TP_POLITICA", nullable = false)
    private String icmIdTpPolitica;

}
