package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

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

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_CALCULAR")
@Data
public class TareaLocalizacionCalcular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_CALCULAR")
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
    private String idLocalizacion;
    
    @NotBlank
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacionMeta4;
    
    @NotNull
    @Column(name = "CALCULA", nullable = false)
    private Boolean calcula;
    
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;
    
    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;
    

}
