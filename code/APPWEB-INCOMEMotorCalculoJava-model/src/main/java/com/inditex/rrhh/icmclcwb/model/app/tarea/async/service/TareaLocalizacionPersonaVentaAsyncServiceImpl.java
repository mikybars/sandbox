package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionPersonaVentaAsyncServiceImpl implements TareaLocalizacionPersonaVentaAsyncService {

  @Autowired
  private TareaLocalizacionPersonaVentaService tareaLocalizacionPersonaVentaService;

  @Override
  public CompletableFuture<Void> savePtrVentaIndividualDetalleResultItem(
      @NotNull List<PtrVentaIndividualDetalleResultItemDto> operaciones, TareaDto tarea) {
    this.tareaLocalizacionPersonaVentaService.savePtrVentaIndividualDetalleResultItem(operaciones, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResultItem(
      @NotNull List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones, TareaDto tarea) {
    this.tareaLocalizacionPersonaVentaService.savePtrVentaOnlineIpodIndividualDetalleResultItem(operaciones, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
