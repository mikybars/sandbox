package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoRepository;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class ProgramacionAmbitoServiceImpl implements ProgramacionAmbitoService {

    @Autowired
    private ProgramacionAmbitoRepository programacionAmbitoRepository;

    @Autowired
    private ProgramacionAmbitoMapper programacionAmbitoMapper;

    @Autowired
    private ProgramacionAmbitoOrigenService programacionAmbitoOrigenService;

    @Autowired
    private ProgramacionAmbitoEmpresaService programacionAmbitoEmpresaService;

    @Autowired
    private ProgramacionAmbitoLocalizacionService programacionAmbitoLocalizacionService;

    @Autowired
    private ProgramacionAmbitoPersonaService programacionAmbitoPersonaService;

    @Override
    public List<ProgramacionAmbitoDto> create(@Valid @NotNull final List<ProgramacionAmbitoDto> programacionAmbito,
            @NotNull ProgramacionDto programacion) {
        List<ProgramacionAmbitoDto> result = new ArrayList<>();
        programacionAmbito.forEach(item -> {
            ProgramacionAmbitoDto programacionAmbitoResult = programacionAmbitoMapper
                    .programacionAmbitoToProgramacionAmbitoDto(programacionAmbitoRepository.save(
                            programacionAmbitoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
                                    item, programacion)));
            if (CollectionUtils.isNotEmpty(item.getOrigen())) {
                programacionAmbitoResult
                        .setOrigen(programacionAmbitoOrigenService.create(item.getOrigen(), programacionAmbitoResult));
            }
            if (CollectionUtils.isNotEmpty(item.getEmpresa())) {
                programacionAmbitoResult.setEmpresa(
                        programacionAmbitoEmpresaService.create(item.getEmpresa(), programacionAmbitoResult));
            }
            if (TipoAmbitoEnum.LOCALIZACION.getId().equals(programacion.getTipoAmbito().getId())) {
                if (CollectionUtils.isNotEmpty(item.getLocalizacion())) {
                    programacionAmbitoResult.setLocalizacion(programacionAmbitoLocalizacionService
                            .create(item.getLocalizacion(), programacionAmbitoResult));
                } else {
                    throw new IcmclcwbException(
                            "No se puede programar por tipo ambito localizacion y no definir localizaciones");
                }
            }
            if (TipoAmbitoEnum.LOCALIZACION.getId().equals(programacion.getTipoAmbito().getId())) {
                if (CollectionUtils.isNotEmpty(item.getPersona())) {
                    programacionAmbitoResult.setPersona(
                            programacionAmbitoPersonaService.create(item.getPersona(), programacionAmbitoResult));
                } else {
                    throw new IcmclcwbException("No se puede programar por tipo ambito persona y no definir personas");
                }
            }
            result.add(programacionAmbitoResult);
        });
        return result;
    }

    @Override
    public List<ProgramacionAmbitoDto> findByProgramacion(@NotNull final ProgramacionDto programacion) {
        List<ProgramacionAmbitoDto> result = programacionAmbitoMapper.programacionAmbitoToProgramacionAmbitoDto(
                programacionAmbitoRepository.findByProgramacionId(programacion.getId()));
        result.forEach(item -> {
            item.setOrigen(programacionAmbitoOrigenService.findByProgramacionAmbito(item));
            item.setEmpresa(programacionAmbitoEmpresaService.findByProgramacionAmbito(item));
            item.setLocalizacion(programacionAmbitoLocalizacionService.findByProgramacionAmbito(item));
            item.setPersona(programacionAmbitoPersonaService.findByProgramacionAmbito(item));
        });
        return result;
    }

}