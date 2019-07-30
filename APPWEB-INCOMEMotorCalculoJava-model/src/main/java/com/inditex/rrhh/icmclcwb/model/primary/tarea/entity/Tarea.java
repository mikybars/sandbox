package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;

import lombok.Data;

@Entity
@Table(name = "TAREA")
@Data
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_ESTADO_TAREA", nullable = false)
    private EstadoTarea estado;

    @NotNull
    @Column(name = "FECHA_HORA_CREACION", nullable = false)
    private Date fechaHoraCreacion;

    @Column(name = "FECHA_HORA_INICIO_TAREA", nullable = true)
    private Date fechaHoraInicioTarea;

    @Column(name = "FECHA_HORA_FIN_TAREA", nullable = true)
    private Date fechaHoraFinTarea;

    @NotBlank
    @Column(name = "ID_ORGANIZATION", nullable = false, length = 48)
    private String idOrganization;

    @NotBlank
    @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
    private String stdIdLegEnt;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TRABAJO")
    private Trabajo trabajo;

}
