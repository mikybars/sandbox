package com.inditex.rrhh.icmclcwb.model.app.run.tarea.migrar;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.migrar.RunTareaMigrarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaMigrarAsyncServiceImpl implements RunTareaMigrarAsyncService {

  @Autowired
  private TareaMigrarService tareaMigrarService;

  @Override
  public CompletableFuture<Void> migrarListCalculoComision(final RunTareaDto runTarea) {
    this.tareaMigrarService.migrarCalculoComision(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }
}
