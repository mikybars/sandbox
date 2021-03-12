package com.inditex.rrhh.icmclcwb.api.app.util;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

    private AppConstants() {
    }

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

    @Getter
    private static final Integer[] SECCIONES = { SECCION_1, SECCION_2, SECCION_3 };

    @Getter
    private static final List<String> SECCIONES_STRING = Arrays.asList("1", "2", "3");

    @Getter
    private static final List<Integer> PRODUCTOS_COMISIONABLES = Arrays.asList(1, 2, 3, 4, 5);

    public static final Float PORCENTAJE_COMISION = 0.01F;

    public static final String OPERACION_DEVOLUCION = "D";

    public static final String OPERACION_VENTA = "V";

    public static final String OPERACION_VENTA_CAJA = "VC";

    public static final String OPERACION_DEVOLUCION_OTRAS_TIENDAS = "DO";

    public static final String EMPRESA_0 = "0";

}
