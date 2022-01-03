package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;

import javax.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPersonaVentaAsyncService {

  CompletableFuture<Void> savePtrVentaIndividualDetalleResultItem(
      @NotNull List<PtrVentaIndividualDetalleResultItemDto> operaciones, TareaDto tarea);

  CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResultItem(
      @NotNull List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones, TareaDto tarea);

}
