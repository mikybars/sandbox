package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionPersonaVentaServiceImpl implements TareaLocalizacionPersonaVentaService {

  @Autowired
  private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

  @Autowired
  private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;

  @Override
  public void savePtrVentaIndividualDetalleResultItem(
      @Valid @NotNull @NotEmpty final List<PtrVentaIndividualDetalleResultItemDto> operaciones,
      @Valid @NotNull final TareaDto tarea) {
    tareaLocalizacionPersonaVentaRepositoryCustom.save(
        tareaLocalizacionPersonaVentaMapper
            .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(operaciones, tarea));
  }

  @Override
  public void savePtrVentaOnlineIpodIndividualDetalleResultItem(
      @Valid @NotNull @NotEmpty final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones,
      @Valid @NotNull final TareaDto tarea) {
    tareaLocalizacionPersonaVentaRepositoryCustom.save(
        tareaLocalizacionPersonaVentaMapper
            .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(operaciones,
                tarea));
  }

}
