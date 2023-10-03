package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PROCESO")
@Data
public class Proceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROCESO")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_ESTADO_PROCESO", nullable = false)
    private EstadoProceso estadoProceso;

    @NotNull
    @Column(name = "ID_ORGANIZATION", nullable = false, length = 48)
    private String idOrganization;

    @NotNull
    @Column(name = "ICM_ID_PERIODO", nullable = false)
    private Long icmIdPeriodo;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_AMBITO", nullable = false)
    private TipoAmbito tipoAmbito;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_PROCESO", nullable = false)
    private TipoProceso tipoProceso;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_SISTEMA_DESTINO", nullable = false)
    private TipoSistemaDestino tipoSistemaDestino;

    @NotNull
    @Column(name = "FECHA_HORA_CREACION", nullable = false)
    private LocalDateTime fechaHoraCreacion;

    @Column(name = "FECHA_HORA_INICIO_PROCESO", nullable = true)
    private LocalDateTime fechaHoraInicioProceso;

    @Column(name = "FECHA_HORA_FIN_PROCESO", nullable = true)
    private LocalDateTime fechaHoraFinProceso;

    @NotNull
    @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
    private LocalDate fechaInicioPeriodo;

    @NotNull
    @Column(name = "FECHA_FIN_PERIODO", nullable = false)
    private LocalDate fechaFinPeriodo;

    @NotNull
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 32)
    private String nombreUsuario;

}
