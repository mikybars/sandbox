package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPersonaVentaService {

  void savePtrVentaIndividualDetalleResultItem(
      @Valid @NonNull @NotEmpty final List<PtrVentaIndividualDetalleResultItemDto> operaciones,
      @Valid @NonNull final TareaDto tarea);

  void savePtrVentaOnlineIpodIndividualDetalleResultItem(
      @Valid @NonNull @NotEmpty final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones,
      @Valid @NonNull final TareaDto tarea);

}
