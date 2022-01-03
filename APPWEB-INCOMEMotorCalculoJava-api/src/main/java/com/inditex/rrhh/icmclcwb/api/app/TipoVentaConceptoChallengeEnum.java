package com.inditex.rrhh.icmclcwb.api.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoVentaConceptoChallengeEnum {

  VENTA_CAJA(1L, "01"), DEVOLUCIONES_OTRAS_TIENDAS(2L, "02"), IPOD(3L, "03"), SINT(4L, "04"), ENTREGA_TIENDA(5L,
      "05"),
  ENTREGA_DOMICILIO(6L, "06");

  private final Long id;

  private final String idMeta4;

}
