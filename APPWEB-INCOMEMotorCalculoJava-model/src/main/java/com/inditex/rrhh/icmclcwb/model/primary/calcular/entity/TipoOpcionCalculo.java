package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//TODO COMENTARIO_DESPLAZAMIENTO descomentar para continuar el desarrollo de desplazamientos
//@Entity
//@Table(name = "TIPO_OPCION_CALCULO")
@Data
public class TipoOpcionCalculo {

    @Id
    @Column(name = "ID_TIPO_OPCION_CALCULO")
    private Integer id;

    @NotBlank
    @Column(name = "ICM_ID_TP_OP_CALC")
    private String idMeta4;

    @NotBlank
    @Column(name = "NOMBRE", length = /*TAMANO_NOMBRE*/ 128, nullable = false)
    private String nombre;

}
