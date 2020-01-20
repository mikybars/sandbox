package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TareaLocalizacionOperacionPersonaService {

    //TODO [javierev] Definir el DTO de las operaciones
    void save(@NotNull List<PtrVentaIndividualDetalleResultItemDto> operaciones, TareaDto tarea);

}
