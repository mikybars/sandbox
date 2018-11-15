package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
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
    public TrabajoDto runTrabajo(@NotNull @Positive final Long id) throws Exception {
//        TrabajoDto result = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id));
//        if (result != null) {
//            result = trabajoRunService.run(result);
//        } else {
//            throw new ApplicationException(new StringBuilder("No existe el trabajo: ").append(id).toString());
//        }
        return trabajoRunService.run(trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id)));
    }

}