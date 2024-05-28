package com.inditex.rrhh.icmclcwb.config.app.ms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class JmsErrorHandlerCustom implements ErrorHandler {

  private static final Logger LOG = LoggerFactory.getLogger(JmsErrorHandlerCustom.class);

  @Override
  public void handleError(Throwable t) {
    if (LOG.isErrorEnabled()) {
      LOG.error("Error :: JmsErrorHandlerCustom.handleError()", t);
    }
  }

}
