package com.inditex.rrhh.icmclcwb.api.ptr.util;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class PtrConstants {

  public static final String DATE_FORMAT = "yyyy-MM-dd";

  public static final String AGRUPAR_SECCION_TRUE = "1";

  public static final String AGRUPAR_SECCION_FALSE = "0";

  public static final String OPERACION_VENTA = "V";

  public static final String OPERACION_VENTA_CAJA = "VC";

  public static final String OPERACION_DEVOLUCION = "D";

  public static final String OPERACION_DEVOLUCION_OTRAS_TIENDAS = "DO";

  public static final String OPERACION_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA = "DT";

  public static final Integer VENDEDOR_0 = 0;

  public static final String EMPRESA_0 = "0";

  public static final String LOCALIZACION_11 = "11";

  @Getter
  private static final List<Integer> VENDEDORES_0 = Arrays.asList(0, -1);

  private PtrConstants() {
  }

}
