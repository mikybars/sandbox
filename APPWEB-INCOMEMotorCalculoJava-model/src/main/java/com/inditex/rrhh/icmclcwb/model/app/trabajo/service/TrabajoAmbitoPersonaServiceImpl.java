package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoAmbitoPersonaServiceImpl implements TrabajoAmbitoPersonaService {

    @Override
    public List<TrabajoAmbitoPersonaDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoPersonaDto> programacionAmbitoPersona,
            @NotNull final TrabajoDto trabajo) {
        // TODO Auto-generated method stub
        return null;
    }

}
