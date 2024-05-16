package com.inditex.rrhh.icmclcwb.async;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.amigafwk.common.executor.ItxExecutorFactory;
import com.inditex.amigafwk.common.executor.ItxExecutorFactoryBean;
import com.inditex.rrhh.icmclcwb.config.async.ExecutorConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class ExecutorConfigTest {

  @Mock
  private ItxExecutorFactory executorFactory;

  @Mock
  private ItxExecutorFactoryBean executorFactoryBean;

  @InjectMocks
  private ExecutorConfig executorConfig;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    when(this.executorFactory.newExecutor()).thenReturn(this.executorFactoryBean);
  }

  @Test
  public void meta4ExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.meta4Executor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void ptrVentaExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.ptrVentaExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void ptrPresenciaExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.ptrPresenciaExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void repositoryPrimaryExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.repositoryPrimaryExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void slrhorcomsExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.slrhorcomsExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void calculoExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.calculoExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void algoritmoCalculoExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.algoritmoCalculoExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void ajusteExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.ajusteExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void algoritmoAjusteExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.algoritmoAjusteExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void regularizarExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.regularizarExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }

  @Test
  public void validacionExecutorShouldReturnExecutorFactoryBean() {
    this.executorConfig.validacionExecutor(this.executorFactory);
    verify(this.executorFactory, times(1)).newExecutor();
  }
}
