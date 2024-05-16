package com.inditex.rrhh.icmclcwb.config.async;

import com.inditex.amigafwk.common.executor.ItxExecutorFactory;
import com.inditex.amigafwk.common.executor.ItxExecutorFactoryBean;
import com.inditex.amigafwk.common.executor.annotation.AmigaExecutor;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

  // TODO: Revisar esto
  @AmigaExecutor("meta4-executor")
  public ItxExecutorFactoryBean meta4Executor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("ptr-venta-executor")
  public ItxExecutorFactoryBean ptrVentaExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("ptr-presencia-executor")
  public ItxExecutorFactoryBean ptrPresenciaExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("repository-primary-executor")
  public ItxExecutorFactoryBean repositoryPrimaryExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("slrhorcoms-executor")
  public ItxExecutorFactoryBean slrhorcomsExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("calculo-executor")
  public ItxExecutorFactoryBean calculoExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("algoritmo-calculo-executor")
  public ItxExecutorFactoryBean algoritmoCalculoExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("ajuste-executor")
  public ItxExecutorFactoryBean ajusteExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("algoritmo-ajuste-executor")
  public ItxExecutorFactoryBean algoritmoAjusteExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("regularizar-executor")
  public ItxExecutorFactoryBean regularizarExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

  @AmigaExecutor("validacion-executor")
  public ItxExecutorFactoryBean validacionExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor();
  }

}
