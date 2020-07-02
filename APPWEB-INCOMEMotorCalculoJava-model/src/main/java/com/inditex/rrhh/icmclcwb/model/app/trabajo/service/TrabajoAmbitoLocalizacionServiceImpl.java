package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoLocalizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoAmbitoLocalizacionServiceImpl implements TrabajoAmbitoLocalizacionService {

    @Autowired
    private TrabajoAmbitoLocalizacionRepository trabajoAmbitoLocalizacionRepository;

    @Autowired
    private TrabajoAmbitoLocalizacionMapper trabajoAmbitoLocalizacionMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<TrabajoAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoLocalizacionDto> trabajoAmbitoLocalizacion,
            @NotNull final TrabajoDto trabajo) {
        return trabajoAmbitoLocalizacionMapper.trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(
                trabajoAmbitoLocalizacionRepository.saveAll(trabajoAmbitoLocalizacionMapper
                    .mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(
                            trabajoAmbitoLocalizacion, trabajo)));
    }

    @Override
    public List<TrabajoAmbitoLocalizacionDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo) {
        return trabajoAmbitoLocalizacionMapper.trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(
                trabajoAmbitoLocalizacionRepository.findByTrabajoId(trabajo.getId()));
    }

}
