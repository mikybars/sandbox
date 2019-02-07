package com.inditex.rrhh.icmclcwb.config.meta4.icmwscalcincome;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.envars.meta4.icmwscalcincome.service")
public class Meta4IcmWsCalcIncomeClientPropertiesConfig {

    private Meta4PropertiesDto getTiendasEmpleado;

    private Meta4PropertiesDto searchTiendas;

    private Meta4PropertiesDto getTiendas;

    private Meta4PropertiesDto searchEmpleados;

    private Meta4PropertiesDto getComisionEmpleado;

    private Meta4PropertiesDto getEmpleados;

    @Bean(name = "getTiendasEmpleadoDto")
    public Meta4PropertiesDto getTiendasEmpleadoPageDto() {
        return getTiendasEmpleado;
    }

    @Bean(name = "searchTiendasDto")
    public Meta4PropertiesDto searchTiendasPageDto() {
        return searchTiendas;
    }

    @Bean(name = "getTiendasDto")
    public Meta4PropertiesDto getTiendasPageDto() {
        return getTiendas;
    }

    @Bean(name = "searchEmpleadosDto")
    public Meta4PropertiesDto searchEmpleadosPageDto() {
        return searchEmpleados;
    }

    @Bean(name = "getComisionEmpleadoDto")
    public Meta4PropertiesDto getComisionEmpleadoPageDto() {
        return getComisionEmpleado;
    }

    @Bean(name = "getEmpleadosDto")
    public Meta4PropertiesDto getEmpleadosPageDto() {
        return getEmpleados;
    }

}
