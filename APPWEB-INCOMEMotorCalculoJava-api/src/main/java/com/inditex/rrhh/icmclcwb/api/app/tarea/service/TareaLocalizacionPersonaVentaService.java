package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPersonaVentaService {

  void savePtrVentaIndividualDetalleResultItem(
      @Valid @NotNull @NotEmpty final List<PtrVentaIndividualDetalleResultItemDto> operaciones,
      @Valid @NotNull final TareaDto tarea);

  void savePtrVentaOnlineIpodIndividualDetalleResultItem(
      @Valid @NotNull @NotEmpty final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones,
      @Valid @NotNull final TareaDto tarea);

}
