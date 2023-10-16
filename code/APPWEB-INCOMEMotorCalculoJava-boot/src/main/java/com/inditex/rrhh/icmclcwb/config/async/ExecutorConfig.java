package com.inditex.rrhh.icmclcwb.config.async;

import com.inditex.aqsw.framework.common.executor.ItxExecutorFactory;
import com.inditex.aqsw.framework.common.executor.ItxExecutorFactoryBean;
import com.inditex.aqsw.framework.common.utils.threads.properties.ExecutorType;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.meta4-executor")
  public ItxExecutorFactoryBean meta4Executor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.ptr-venta-executor")
  public ItxExecutorFactoryBean ptrVentaExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.ptr-presencia-executor")
  public ItxExecutorFactoryBean ptrPresenciaExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.repository-primary-executor")
  public ItxExecutorFactoryBean repositoryPrimaryExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.slrhorcoms-executor")
  public ItxExecutorFactoryBean slrhorcomsExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.calculo-executor")
  public ItxExecutorFactoryBean calculoExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.algoritmo-calculo-executor")
  public ItxExecutorFactoryBean algoritmoCalculoExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.ajuste-executor")
  public ItxExecutorFactoryBean ajusteExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.algoritmo-ajuste-executor")
  public ItxExecutorFactoryBean algoritmoAjusteExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.regularizar-executor")
  public ItxExecutorFactoryBean regularizarExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.common.executor.validacion-executor")
  public ItxExecutorFactoryBean validacionExecutor(final ItxExecutorFactory executorFactory) {
    return executorFactory.newExecutor(ExecutorType.THREAD_POOL);
  }

}
