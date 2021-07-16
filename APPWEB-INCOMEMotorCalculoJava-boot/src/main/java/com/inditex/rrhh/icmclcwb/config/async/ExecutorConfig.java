package com.inditex.rrhh.icmclcwb.config.async;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.aqsw.framework.common.executor.ItxExecutorFactory;
import com.inditex.aqsw.framework.common.executor.ItxExecutorFactoryBean;
import com.inditex.aqsw.framework.common.utils.threads.properties.ExecutorType;

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

}
