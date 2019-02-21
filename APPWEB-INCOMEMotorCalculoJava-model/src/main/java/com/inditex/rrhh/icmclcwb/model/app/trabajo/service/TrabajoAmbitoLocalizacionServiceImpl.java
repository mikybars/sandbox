package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoAmbitoLocalizacionServiceImpl implements TrabajoAmbitoLocalizacionService {

    @Override
    public List<TrabajoAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoLocalizacionDto> programacionAmbitoLocalizacion,
            @NotNull final TrabajoDto trabajo) {
        // TODO Auto-generated method stub
        return null;
    }

}
