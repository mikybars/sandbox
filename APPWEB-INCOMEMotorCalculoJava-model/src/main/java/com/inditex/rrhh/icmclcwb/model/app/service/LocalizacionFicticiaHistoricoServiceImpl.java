package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionFicticiaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.LocalizacionFicticiaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.LocalizacionFicticiaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.LocalizacionFicticiaHistoricoRepositoryCustom;

@Service
@Validated
public class LocalizacionFicticiaHistoricoServiceImpl implements LocalizacionFicticiaHistoricoService {

    @Autowired
    private LocalizacionFicticiaHistoricoRepositoryCustom localizacionFicticiaHistoricoRepositoryCustom;

    @Autowired
    private LocalizacionFicticiaHistoricoMapper localizacionFicticiaHistoricoMapper;

    @Override
    // TODO Asignar cache
    // @Cacheable(value = "itx.icmlcwb.ASIGNAR", key = "{#idTarea, #cclIdOrigen}")
    public List<LocalizacionFicticiaHistoricoDto> FindLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha(
            final TareaDto tarea,
            final TareaAmbitoDto ambito) {
        return null;
    }

}
