package com.inditex.rrhh.icmclcwb.config.app.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ErrorHandler;

public class JmsErrorHandlerCustom implements ErrorHandler {

  @Autowired
  private Logger log;

  @Override
  public void handleError(Throwable t) {
    if (log.isErrorEnabled()) {
      log.error("Error :: JmsErrorHandlerCustom.handleError()", t);
    }
  }

}
