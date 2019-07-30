package com.inditex.rrhh.icmclcwb.api.app.util;

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

    public static final Integer[] SECCIONES = { SECCION_1, SECCION_2, SECCION_3 };
    
    public static final List<String> SECCIONES_STRING = Arrays.asList("1", "2", "3");
    
    public static final List<Integer> PRODUCTOS_COMISIONABLES = Arrays.asList(1, 2, 3, 4, 5);

}
