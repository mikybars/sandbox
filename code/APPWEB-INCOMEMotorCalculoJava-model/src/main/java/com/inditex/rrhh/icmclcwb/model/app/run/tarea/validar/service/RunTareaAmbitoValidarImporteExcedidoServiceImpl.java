package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.SincronizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarImporteExcedidoService;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaImporteExcedidoService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarImporteExcedidoServiceImpl implements RunTareaAmbitoValidarImporteExcedidoService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoValidarImporteExcedidoServiceImpl.class);

  @Autowired
  private TareaFaseAccionServiceImpl tareaFaseAccionService;

  @Autowired
  private TareaImporteExcedidoService tareaImporteExcedidoService;

  @Autowired
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  @Autowired
  private MailService mailService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  public ValidacionDto execute(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {

    final List<IdPersonaLocalDto> importeExcedidoValidationResult;
    final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoList = new ArrayList<>();
    final List<ValidacionDto> validacionDtos = new ArrayList<>();

    try {
      importeExcedidoValidationResult = this.tareaImporteExcedidoService.findPersonaImporteExcedidoByIdTarea(tareaAmbito.getIdTarea());

      importeExcedidoValidationResult
          .forEach(persona -> tareaFaseAccionDatoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
              .idTipoDato(TipoDatoEnum.PERSONA.getId()).dato(persona.getIdPersonaLocal()).build()));
      this.tareaFaseAccionFallidasService.save(tareaFaseAccionDatoList);

      validacionDtos
          .add(this.validacionMapper.idPersonaLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion, importeExcedidoValidationResult,
              PrevalidarPropertiesDto.builder().sincronizacion(SincronizacionDto.builder().activo(false).build()).build(),
              runTareaDto.getTarea()));
      this.mailService.sendMail(validacionDtos, runTareaDto);
    } catch (final Exception e) {
      RunTareaAmbitoValidarImporteExcedidoServiceImpl.LOG.error(
          "Trabajo[{}]Tarea[{}] :: Fin :: RunTareaAmbitoValidarImporteExcedidoServiceImpl :: ImporteExcedido",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), e);
    }
    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }
}
