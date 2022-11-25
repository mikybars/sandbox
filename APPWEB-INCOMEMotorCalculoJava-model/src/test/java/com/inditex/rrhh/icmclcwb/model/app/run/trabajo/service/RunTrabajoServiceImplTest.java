package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;
/*
 * Copyright (c) 2022. Inditex
 */

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTrabajoServiceImplTest {

  @Mock
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Mock
  private TrabajoService trabajoService;

  @Mock
  private TareaService tareaService;

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @InjectMocks
  private RunTrabajoServiceImpl runTrabajoService;

  private static final String ORIGEN = "1";

  private static final String EMPRESA = "1";

  private RunTrabajoDto createRunTrabajo(final Long id) {
    final RunTrabajoDto runTrabajoDto = new RunTrabajoDto();
    runTrabajoDto.setTarea(Arrays.asList(new TareaDto()));
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    final TrabajoAmbitoOrigenDTO origen = new TrabajoAmbitoOrigenDTO();
    final TrabajoAmbitoEmpresaDTO empresa = new TrabajoAmbitoEmpresaDTO();
    origen.setCclIdOrigen(ORIGEN);
    origen.setIdTrabajo(1L);
    tipoAmbito.setId(id);
    trabajoDto.setTipoAmbito(tipoAmbito);
    trabajoDto.setOrigen(new ArrayList<>());
    trabajoDto.getOrigen().add(origen);
    trabajoDto.setEmpresa(new ArrayList<>());
    trabajoDto.getEmpresa().add(empresa);
    trabajoDto.setIdProgramacion(1L);
    runTrabajoDto.setTrabajo(trabajoDto);
    return runTrabajoDto;
  }

  @Test
  void runSociedadTest() {

    final RunTrabajoDto runTrabajoDto = this.createRunTrabajo(TipoAmbitoEnum.SOCIEDAD.getId());
    final Meta4PropertiesDto m4 = new Meta4PropertiesDto();
    m4.setPage(new PageDto());
    final OrigenResultItemDto origen = new OrigenResultItemDto();
    origen.setIdOrigen(ORIGEN);
    when(this.meta4Properties.get(Meta4PropertiesConstants.ORIGEN)).thenReturn(m4);
    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPRESA)).thenReturn(m4);
    when(this.meta4IcmWsCalcIncomeSessionService.getOrigen(any(OrigenRequestDto.class)))
        .thenReturn(Arrays.asList(origen));
    this.runTrabajoService.run(runTrabajoDto);

  }

  @Test
  void runOrigenTest() {

    final RunTrabajoDto runTrabajoDto = this.createRunTrabajo(TipoAmbitoEnum.ORIGEN.getId());
    final Meta4PropertiesDto m4 = new Meta4PropertiesDto();
    m4.setPage(new PageDto());
    final EmpresaResultItemDto empresa = new EmpresaResultItemDto();
    empresa.setIdEmpresa(EMPRESA);
    when(this.meta4Properties.get(Meta4PropertiesConstants.ORIGEN)).thenReturn(m4);
    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPRESA)).thenReturn(m4);
    when(this.meta4IcmWsCalcIncomeSessionService.getEmpresa(any(EmpresaRequestDto.class)))
        .thenReturn(Arrays.asList(empresa));

    this.runTrabajoService.run(runTrabajoDto);

  }

  @Test
  void runEmpresaTest() {

    final RunTrabajoDto runTrabajoDto = this.createRunTrabajo(TipoAmbitoEnum.EMPRESA.getId());
    final TareaFaseDto fase = TareaFaseDto.builder().id(199L).build();
    final Meta4PropertiesDto m4 = new Meta4PropertiesDto();
    m4.setPage(new PageDto());
    final IdOrigenEmpresaDto empresa = new IdOrigenEmpresaDto();
    empresa.setStdIdLegEnt(EMPRESA);
    when(this.meta4Properties.get(Meta4PropertiesConstants.ORIGEN)).thenReturn(m4);
    when(this.meta4Properties.get(Meta4PropertiesConstants.EMPRESA)).thenReturn(m4);
    when(this.trabajoService.findEmpresasCalcularProgramados(any(TrabajoDTO.class), any(List.class), any(List.class)))
        .thenReturn(Arrays.asList(empresa));
    this.runTrabajoService.run(runTrabajoDto);

  }
}
