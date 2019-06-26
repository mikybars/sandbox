package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import lombok.Data;

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
import java.util.Date;

@Entity
@Table(name = "TAREA_LOCALIZACION_ONLINE_HISTORICO")
@Data
public class TareaLocalizacionOnlineHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_ONLINE_HISTORICO")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;

    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
    private String idLocalizacion;

    @NotBlank
    @Column(name = "STD_ID_WORK_LOCAT", nullable = true)
    private String idLocalizacionMeta4;

    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false)
    private String idPais;

    @NotBlank
    @Column(name = "STD_ID_LEG_ENT", nullable = false)
    private String idEmpresa;

    @NotBlank
    @Column(name = "CCL_ID_CADENA", nullable = false)
    private String idCadena;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;

}
