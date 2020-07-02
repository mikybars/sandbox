package com.inditex.rrhh.icmclcwb.config.async;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.aqsw.framework.common.executor.ItxExecutorFactory;
import com.inditex.aqsw.framework.common.executor.ItxThreadPoolExecutorFactoryBean;

@Configuration
public class ExecutorConfig {

    @Bean
    @ConfigurationProperties(prefix = "amiga.common.executor.meta4-executor")
    public ItxThreadPoolExecutorFactoryBean meta4Executor(ItxExecutorFactory executorFactory) {
        return executorFactory.newThreadPoolExecutorFactory();
    }

    @Bean
    @ConfigurationProperties(prefix = "amiga.common.executor.ptr-venta-executor")
    public ItxThreadPoolExecutorFactoryBean ptrVentaExecutor(ItxExecutorFactory executorFactory) {
        return executorFactory.newThreadPoolExecutorFactory();
    }

    @Bean
    @ConfigurationProperties(prefix = "amiga.common.executor.ptr-presencia-executor")
    public ItxThreadPoolExecutorFactoryBean ptrPresenciaExecutor(ItxExecutorFactory executorFactory) {
        return executorFactory.newThreadPoolExecutorFactory();
    }

    @Bean
    @ConfigurationProperties(prefix = "amiga.common.executor.repository-primary-executor")
    public ItxThreadPoolExecutorFactoryBean repositoryPrimaryExecutor(ItxExecutorFactory executorFactory) {
        return executorFactory.newThreadPoolExecutorFactory();
    }

}
