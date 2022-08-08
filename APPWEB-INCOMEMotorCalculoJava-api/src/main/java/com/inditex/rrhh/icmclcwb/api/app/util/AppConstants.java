package com.inditex.rrhh.icmclcwb.api.app.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.EstadoTrabajoEnum;

import lombok.Getter;

public class AppConstants {

  public static final String LOCAL_TIME_PATTERN = "([01][0-9]|2[0-3]):[0-5][0-9]";

  public static final String LOCAL_TIME_JSON = "HH:mm";

  public static final Integer SECCION_0 = 0;

  public static final Integer SECCION_1 = 1;

  public static final Integer SECCION_2 = 2;

  public static final Integer SECCION_3 = 3;

  public static final Integer SECCION_4 = 4;

  public static final String VALOR_DEFAULT = "0";

  public static final String ID_TIPO_VENTA_DEFAULT = "01";

  public static final Integer TOPE_DEFAULT = 0;

  public static final Float PORCENTAJE_COMISION = 0.01F;

  public static final String OPERACION_DEVOLUCION = "D";

  public static final String OPERACION_VENTA = "V";

  public static final String OPERACION_VENTA_CAJA = "VC";

  public static final String OPERACION_DEVOLUCION_OTRAS_TIENDAS = "DO";

  public static final String OPERACION_DEVOLUCION_VENTA_ORIGINAL_OTRA_TIENDA = "DT";

  public static final String EMPRESA_0 = "0";

  public static final String ID_ORIGEN_SPAIN = "11";

  public static final int ID_ORIGEN_MONACO_PTR = 101;

  public static final String STD_ID_LEG_ENT_MONACO = "168";

  public static final String UNDERSCORE = "_";

  public static final Long MIN_ID_PERSONA_EXTERNO_ES = 500000L;

  public static final Long MIN_ID_PERSONA_EXTERNO_NO_ES = 90000000L;

  public static final Collection<Integer> ESTADOS_RUN_TAREA_OK = Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(),
      EstadoTareaEnum.EN_CURSO.getId(), EstadoTareaEnum.ERROR_VALIDANDO.getId());

  public static final Collection<Integer> ESTADOS_RUN_TRABAJO_OK = Arrays.asList(EstadoTrabajoEnum.PENDIENTE.getId());

  @Getter
  private static final Integer[] SECCIONES = {SECCION_1, SECCION_2, SECCION_3};

  @Getter
  private static final List<String> SECCIONES_STRING = Arrays.asList("1", "2", "3");

  @Getter
  private static final List<Integer> PRODUCTOS_COMISIONABLES = Arrays.asList(1, 2, 3, 4, 5);

  @Getter
  private static final List<String> TIPOS_CALCULO_CHALLENGE =
      Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
          TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId());

  @Getter
  private static final List<String> TIPOS_COMISION_CHALLENGE =
      Arrays.asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId());

  private AppConstants() {
  }

}
