package com.inditex.rrhh.icmclcwb.config.ptr;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;

@Configuration
@ConfigurationProperties(prefix = "app.envars.ptr.venta.service")
public class PtrClientVentaPropertiesConfig {

	PtrPropertiesDto getVentaTotalizado;

	PtrPropertiesDto getVentaIndividualDetalle;

	@Bean(name = "ventaTotalizadoDto")
	public PtrPropertiesDto getVentaTotalizado() {
		return getVentaTotalizado;
	}

	@Bean(name = "ventaIndividualDetalleDto")
	public PtrPropertiesDto getVentaIndividualDetalle() {
		return getVentaIndividualDetalle;
	}

}
