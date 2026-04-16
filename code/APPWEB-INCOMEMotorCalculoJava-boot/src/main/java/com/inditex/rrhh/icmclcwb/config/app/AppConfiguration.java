package com.inditex.rrhh.icmclcwb.config.app;

import com.inditex.amigafwk.data.jpa.annotations.AmigaEnableJpaRepositories;

import org.springframework.context.annotation.Configuration;

/**
 * Clase que configura la aplicación. Se utiliza en vez del xml para configurar el contexto de Spring Los objetos devueltos por los métodos
 * que tengan la anotación @Bean serán añadidos al contexto de Spring, y estarán disponibles para su utilización por otros componentes
 * mediante AutoWiring.
 */
@Configuration
@AmigaEnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", basePackages = {
    "com.inditex.rrhh.icmclcwb.model.primary"})
public class AppConfiguration {

}
