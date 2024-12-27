package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoRepository;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  public List<ProgramacionAmbitoDTO> create(@Valid @NonNull final List<ProgramacionAmbitoDTO> programacionAmbito,
      @NonNull final ProgramacionDTO programacion) {
    final List<ProgramacionAmbitoDTO> result = new ArrayList<>();
    programacionAmbito.forEach(item -> {
      final ProgramacionAmbitoDTO programacionAmbitoResult = this.programacionAmbitoMapper
          .programacionAmbitoToProgramacionAmbitoDto(this.programacionAmbitoRepository.save(
              this.programacionAmbitoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
                  item, programacion)));
      if (CollectionUtils.isNotEmpty(item.getOrigen())) {
        programacionAmbitoResult
            .setOrigen(this.programacionAmbitoOrigenService.create(item.getOrigen(), programacionAmbitoResult));
      }
      if (CollectionUtils.isNotEmpty(item.getEmpresa())) {
        programacionAmbitoResult.setEmpresa(
            this.programacionAmbitoEmpresaService.create(item.getEmpresa(), programacionAmbitoResult));
      }
      if (TipoAmbitoEnum.LOCALIZACION.getId().equals(programacion.getTipoAmbito().getId())) {
        if (CollectionUtils.isNotEmpty(item.getLocalizacion())) {
          programacionAmbitoResult.setLocalizacion(this.programacionAmbitoLocalizacionService
              .create(item.getLocalizacion(), programacionAmbitoResult));
        } else {
          throw new IcmclcwbException(
              "No se puede programar por tipo ambito localizacion y no definir localizaciones");
        }
      }
      if (TipoAmbitoEnum.PERSONA.getId().equals(programacion.getTipoAmbito().getId())) {
        if (CollectionUtils.isNotEmpty(item.getPersona())) {
          programacionAmbitoResult.setPersona(
              this.programacionAmbitoPersonaService.create(item.getPersona(), programacionAmbitoResult));
        } else {
          throw new IcmclcwbException("No se puede programar por tipo ambito persona y no definir personas");
        }
      }
      result.add(programacionAmbitoResult);
    });
    return result;
  }

  @Override
  public List<ProgramacionAmbitoDTO> findByProgramacion(@NonNull final ProgramacionDTO programacion) {
    final List<ProgramacionAmbitoDTO> result = this.programacionAmbitoMapper
        .programacionAmbitoToProgramacionAmbitoDto(
            this.programacionAmbitoRepository.findByProgramacionId(programacion.getId()));
    result.forEach(item -> {
      item.setOrigen(this.programacionAmbitoOrigenService.findByProgramacionAmbito(item));
      item.setEmpresa(this.programacionAmbitoEmpresaService.findByProgramacionAmbito(item));
      item.setLocalizacion(this.programacionAmbitoLocalizacionService.findByProgramacionAmbito(item));
      item.setPersona(this.programacionAmbitoPersonaService.findByProgramacionAmbito(item));
    });
    return result;
  }

}
