package com.inditex.rrhh.icmclcwb.api.app.util;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;

public class AppConstants {

    private AppConstants() {
    }

    public static final String LOCAL_TIME_PATTERN = "([01][0-9]|2[0-3]):[0-5][0-9]";

    public static final String LOCAL_TIME_JSON = "HH:mm";

    public static final String SEPARATOR_DATA = "|";

    public static final String PREFIJO_TIENDA_META4 = "T";

    public static final Integer SECCION_0 = 0;
    
    public static final Integer SECCION_1 = 1;
    
    public static final Integer SECCION_2 = 2;
    
    public static final Integer SECCION_3 = 3;
    
    public static final Integer SECCION_4 = 4;
    
    // TODO Se tiene que obtener de BBDD
    @Deprecated
    public static final List<Long> ID_TIPO_IMPORTE_VENTA_ONLINE = Arrays.asList(
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_PERSONA.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_OPERACION_LOCALIZACION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId(),
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION.getId());

}
