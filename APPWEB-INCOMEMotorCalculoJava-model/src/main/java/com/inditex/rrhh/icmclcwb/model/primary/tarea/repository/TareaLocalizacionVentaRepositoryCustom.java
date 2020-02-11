package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface TareaLocalizacionVentaRepositoryCustom {

    List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src);

    void updateActivo(TareaDto tarea, TipoVentaConceptoEnum tipoVentaConceptoEnum, List<Integer> idsTipoDato);

    void updateActivoTrasladadas(TareaDto tarea);

    void totalizarOperacionesLocalizacionSeccion(TareaDto tarea, boolean devolucion);

    void totalizarVentaPersonasPorVenta(TareaDto tarea, TipoCalculoEnum tipoCalculo);

    void calcularImporteComisionVendedores(TareaDto tarea);

    void calcularImporteComisionVentaODevolucion(TareaDto tarea);

    void updateActivoNegativoTotalizado(@NotNull TareaDto tarea);

}
