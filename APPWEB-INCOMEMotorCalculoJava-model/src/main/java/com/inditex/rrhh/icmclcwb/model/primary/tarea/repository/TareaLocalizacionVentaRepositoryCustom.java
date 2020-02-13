package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

public interface TareaLocalizacionVentaRepositoryCustom {

    List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src);

    void updateActivo(TareaDto tarea, TipoVentaConceptoEnum tipoVentaConceptoEnum, List<Integer> idsTipoDato);

    void updateActivoTrasladadas(TareaDto tarea);
    
    void updateActivoNegativoTotalizado(@NotNull TareaDto tarea);

}
