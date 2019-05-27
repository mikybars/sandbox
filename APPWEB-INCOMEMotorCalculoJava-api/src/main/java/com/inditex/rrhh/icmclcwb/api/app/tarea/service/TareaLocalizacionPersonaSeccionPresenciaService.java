package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

public interface TareaLocalizacionPersonaSeccionPresenciaService {

    void save(@NotNull List<GenericEmpleadoResultItemDto> src, @NotNull TareaDto tareaDto);

    void updateActivo(@NotNull RunTareaDto tareaDto);

    void savePtrPresenciaDetalle(@NotNull List<PtrPresenciaDetalleResultItemDto> src, @NotNull TareaDto tareaDto);

}
