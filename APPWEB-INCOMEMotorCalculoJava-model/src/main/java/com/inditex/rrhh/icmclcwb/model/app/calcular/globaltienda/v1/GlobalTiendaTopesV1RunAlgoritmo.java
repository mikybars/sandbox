package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltienda.v1;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("globalTiendaTopesV1")
public class GlobalTiendaTopesV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private Logger log;

  @Autowired
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Override
  public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
    this.log.warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    this.log.warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    return ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT;
  }

}
