package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.validacion.entity.TipoValidacion;
import lombok.Data;

@Embeddable
@Data
public class TareaPrevalidacionValidacionPk implements Serializable {

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_VALIDACION", nullable = false)
    private TipoValidacion tipoValidacion;
    
    @NotNull
    @OneToOne
//    @JoinColumn(name = "ID_TAREA_PREVALIDACION", nullable = false)
    @JoinColumns({
        @JoinColumn(
            name = "ID_TAREA_PREVALIDACION",
            referencedColumnName = "ID_TAREA_PREVALIDACION"),
        @JoinColumn(
            name = "ID_TAREA",
            referencedColumnName = "ID_TAREA")
    })
    private TareaPrevalidacion tareaPrevalidacion;
    
//    @NotNull
//    @OneToOne
//    @JoinColumn(name = "ID_TAREA", insertable = false, updatable = false)
//    private Tarea tarea;

}
