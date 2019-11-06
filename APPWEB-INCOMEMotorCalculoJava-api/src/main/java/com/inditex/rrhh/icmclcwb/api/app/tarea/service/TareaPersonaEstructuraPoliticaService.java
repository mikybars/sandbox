package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaPersonaEstructuraPoliticaService {

    List<TareaPersonaEstructuraPoliticaDto> save(final List<ComisionEmpleadoResultItemDto> tareaEmpleadoSeccionEstructuraPolitica,
        @Valid final TareaDto tarea);

    List<TareaPersonaEstructuraPoliticaDto> saveEstructurasPolResultItemDto(
            final List<EstructurasPolResultItemDto> estructurasPolResultItemDto, @Valid final TareaDto tarea);

}
