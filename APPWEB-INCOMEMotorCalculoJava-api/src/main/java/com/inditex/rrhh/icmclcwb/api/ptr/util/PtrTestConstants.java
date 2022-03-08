package com.inditex.rrhh.icmclcwb.api.ptr.util;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class PtrTestConstants {

  public static final String FECHA_DESDE = "2017-12-01";

  public static final String FECHA_HASTA = "2017-12-01";

  public static final Integer ORIGEN = 11;

  public static final Integer PAIS = 11;

  public static final Integer CADENA = 1;

  public static final Integer ID_EMPRESA = 95;

  public static final Integer ID_EMPRESA_VENTA_ECOMMERCE = 329;

  public static final Integer ID_EMPRESA_VENTA_EMPLEADO = 8;

  public static final Integer AGRUPAR_SECCION_TRUE = 1;

  public static final Integer AGRUPAR_SECCION_FALSE = 0;

  public static final Integer TIPO = 1;

  public static final Integer SECCION = 1;

  public static final String AGRUPACION = "TIENDA";

  public static final String AGRUPACION_FECHA_TIENDA = "FECHA_TIENDA";

  public static final Integer INCLUIR_VENTA_PAT = 1;

  public static final Integer EXCLUIDO_IPOD = 1;

  @Getter
  private static final List<Integer> CADENA_LIST = Arrays.asList(1);

  @Getter
  private static final List<Integer> EMPRESA_LIST = Arrays.asList(95);

  @Getter
  private static final List<Integer> PERSONA_LIST = Arrays.asList(1645, 1000);

  @Getter
  private static final List<Integer> TIPO_LIST = Arrays.asList(1000);

  @Getter
  private static final List<Integer> ORIGEN_LIST = Arrays.asList(11);

  @Getter
  private static final List<Integer> ID_TIENDA_LIST = Arrays.asList(57);

  @Getter
  private static final List<Integer> ID_TIENDA_VENTA_EMPLEADO = Arrays.asList(125);

  @Getter
  private static final List<String> ID_TIENDA_ONLINE_LIST = Arrays.asList("9724");

  @Getter
  private static final List<Integer> ID_TIENDA_ONLINE_LIST2 = Arrays.asList(4031);

  @Getter
  private static final List<Integer> ID_TIPO_SECCION = Arrays.asList(1);

  private PtrTestConstants() {
  }

}
