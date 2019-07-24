package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_POLITICA")
@Data
public class TareaPersonaEstructuraPolitica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_PERSONA_ESTRUCTURA_POLITICA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String idOrigen;

    @NotBlank
    @Column(name = "STD_ID_HR", nullable = false, length = 18)
    private String idPersona;

    @NotBlank
    @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
    private String orPersona;

    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String idPersonaLocal;

    //TODO: normalizar el nombre de esta columna (¿ICM_ID_ESTR_POLITICA?)
    @NotBlank
    @Column(name = "ID_ESTRUCTURA_POLITICA", nullable = false)
    private String idEstructuraPolitica;

    //TODO: normalizar el nombre de esta columna (¿ICM_ID_TP_POLITICA?)
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_POLITICA")
    private TipoPolitica tipoPolitica;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "ES_EXCLUIDO_DENOMINADOR", nullable = false)
    private Boolean excluidoDenominador;
}
