package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import java.time.LocalTime;
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

import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROGRAMACION")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Programacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROGRAMACION")
    private Long id;

    @NotNull
    @Column(name = "HORA_PROGRAMACION", nullable = false)
    private LocalTime hora;

    @NotNull
    @Column(name = "PROGRAMACION_HUSO", length = 12, nullable = false)
    private String huso;

    @NotNull
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean activo;

    @NotBlank
    @Column(name = "ID_USUARIO", nullable = false)
    private String idUsuario;

    @NotNull
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "FECHA_HORA_ULTIMA_EJECUCION", nullable = true)
    private Date fechaUltimaEjecucion;

    @NotNull
    @Column(name = "FECHA_SIGUIENTE_EJECUCION", nullable = false)
    private Date fechaSiguienteEjecucion;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_AMBITO", nullable = false)
    private TipoAmbito tipoAmbito;

}
