package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoAmbitoOrigenServiceImpl implements TrabajoAmbitoOrigenService {

    @Override
    public List<TrabajoAmbitoOrigenDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoOrigenDto> programacionAmbitoOrigen,
            @NotNull final TrabajoDto trabajo) {
        // TODO Auto-generated method stub
        return null;
    }

}
