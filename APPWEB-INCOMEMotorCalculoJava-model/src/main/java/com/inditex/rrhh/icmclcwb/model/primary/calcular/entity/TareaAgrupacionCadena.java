package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_CADENA")
@Data
public class TareaAgrupacionCadena {

    @Id
    @Column(name = "ID_TAREA_AGRUPACION_CADENA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;

    @NotBlank
    @Column(name = "ID_ORIGEN")
    private String idOrigen;

    @NotBlank
    @Column(name = "ID_AGRUPACION")
    private Long idAgrupacion;

    @NotBlank
    @Column(name = "ID_CADENA")
    private String idCadena;

    @NotBlank
    @Column(name = "MULTIPLE")
    private Boolean multiple;

}
