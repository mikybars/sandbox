package com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class GetVentaTotalizadoResponseDTO implements Serializable {

	private static final long serialVersionUID = -2758503405995399894L;

	private LocalDateTime fecha;

	private String pais;

	private String cadena;

	private String tienda;

	private String seccion;

	private String temporada;

	private String producto;

	private BigDecimal importeSinIVA;

	private BigDecimal importeConIVA;

}