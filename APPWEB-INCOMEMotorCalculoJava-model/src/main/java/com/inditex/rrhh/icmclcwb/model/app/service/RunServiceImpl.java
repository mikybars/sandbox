package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private TrabajoRunService trabajoRunService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Override
    public TrabajoRunDto runTrabajo(@NotNull @Positive final Long id) throws Exception {
        TrabajoRunDto trabajoRunDto = new TrabajoRunDto();
        trabajoRunDto.setTrabajoDto(trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id)));
        return trabajoRunService.run(trabajoRunDto);
    }

}