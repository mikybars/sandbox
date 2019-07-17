package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaPersonaEstructuraPoliticaServiceImpl implements TareaPersonaEstructuraPoliticaService {

    @Autowired
    private TareaPersonaEstructuraPoliticaRepositoryCustom tareaPersonaEstructuraPoliticaRepositoryCustom;

    @Autowired
    private TareaPersonaEstructuraPoliticaMapper tareaPersonaEstructuraPoliticaMapper;

    @Override
    public List<TareaPersonaEstructuraPoliticaDto> save(List<ComisionEmpleadoResultItemDto> tareaEmpleadoEstructuraPolitica, @Valid TareaDto tarea) {
        return tareaPersonaEstructuraPoliticaMapper.tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
            tareaPersonaEstructuraPoliticaRepositoryCustom.save(tareaPersonaEstructuraPoliticaMapper
                .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(tareaEmpleadoEstructuraPolitica, tarea)));
    }

}
