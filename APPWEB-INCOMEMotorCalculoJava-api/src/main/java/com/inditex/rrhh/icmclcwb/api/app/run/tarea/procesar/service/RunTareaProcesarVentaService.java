package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaProcesarVentaService {

    void saveAbierto(@Valid RunTareaDto runTarea);

    void saveCerrado(@Valid RunTareaDto runTarea);

    void trasladar(@Valid RunTareaDto runTarea);

    void compensar(@Valid RunTareaDto runTarea);

    void repartoVentaEntregaDomicilioAgrupaciones(@Valid RunTareaDto runTarea);

    void repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(@Valid RunTareaDto runTarea);

    void repartoVentaEntregaDomicilioSeccion(@Valid RunTareaDto runTarea);

    void updateActivoTrasladadas(@Valid RunTareaDto runTarea);

    void saveAbiertoSeccion(@Valid RunTareaDto runTarea);

    void saveCerradoSeccion(@Valid RunTareaDto runTarea);

    void compensarOnlineSeccionCerrada(@Valid RunTareaDto runTarea);

    void updateActivoTrasladadasSeccion(@Valid RunTareaDto runTarea);

    void agruparOnlineSeccionDia(@Valid RunTareaDto runTarea);

    void updateActivoTrasladadasTotalizado(@Valid RunTareaDto runTarea);
    
    void updateActivoNegativoTotalizado(@Valid RunTareaDto tarea);

    void updateImporteEstructuraPoliticas(@Valid RunTareaDto runTarea);

    void totalizarDevolucionLocalizacionSeccion(@Valid RunTareaDto runTarea);

    void totalizarVentasSinDevolucionLocalizacionSeccion(@Valid RunTareaDto runTarea);

    void totalizarVentaSinDevolucionPersonasPorVenta(@Valid RunTareaDto tarea);

    void totalizarVentaPersonasPorVentaSimplificada(@Valid RunTareaDto tarea);

    void totalizarVentaPersonaSeccion(@Valid RunTareaDto tarea);

    void totalizarVentaSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea);

    void totalizarDevolucionPersonaSeccion(@Valid RunTareaDto tarea);

    void totalizarVentaFisicaSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea);

    void totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea);

    void totalizarDevolucionFisicaPersonaSeccion(@Valid RunTareaDto tarea);

    void totalizarDevolucionOnlineIpodPersonaSeccion(@Valid RunTareaDto tarea);

    void calcularImporteComisionVendedores(@Valid RunTareaDto tarea);

    void calcularImporteComisionVentaODevolucion(@Valid RunTareaDto tarea);

    void updateActivoNegativoTotalizado(@Valid RunTareaDto tarea);

}
