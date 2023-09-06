package com.inditex.rrhh.icmclcwb.api.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoVentaConceptoEnum {

  IPOD(1L, "01"), SINT(2L, "02"), ENTREGA_TIENDA(3L, "03"), ENTREGA_DOMICILIO_POR_VENTA(4L,
      "04"),
  ENTREGA_DOMICILIO_POR_PRESENCIAS(5L, "05");

  private final Long id;

  private final String idMeta4;

}
