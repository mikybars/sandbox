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

    void totalizarVentasSinDevolucionLocalizacionSeccion(TareaDto tarea);

    void totalizarDevolucionLocalizacionSeccion(TareaDto tarea);

    void totalizarVentaPersonasPorVentaSimplificada(TareaDto tarea);

    void totalizarVentaSinDevolucionPersonasPorVenta(TareaDto tarea);

    void calcularImporteComisionVendedores(TareaDto tarea);

    void calcularImporteComisionVentaODevolucion(TareaDto tarea);

    void updateActivoNegativoTotalizado(@NotNull TareaDto tarea);

    void totalizarVentasVendedor0(@NotNull TareaDto tarea);

    void repartoDevolucionVendedor0(@NotNull TareaDto tarea);

    void updateActivoManual(@NotNull TareaDto tarea);

}
