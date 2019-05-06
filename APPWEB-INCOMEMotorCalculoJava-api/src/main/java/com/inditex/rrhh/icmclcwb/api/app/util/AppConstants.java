package com.inditex.rrhh.icmclcwb.api.app.util;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;

public class AppConstants {

    private AppConstants() {
    }

    public static final String LOCAL_TIME_PATTERN = "([01][0-9]|2[0-3]):[0-5][0-9]";

    public static final String LOCAL_TIME_JSON = "HH:mm";

    public static final String SEPARATOR_DATA = "|";

    public static final String PREFIJO_TIENDA_META4 = "T";

    // TODO Se tiene que obtener de BBDD
    @Deprecated
    public static final List<Long> ID_TIPO_IMPORTE_VENTA_ONLINE = Arrays.asList(
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_PERSONA.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_OPERACION_LOCALIZACION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId(),
            TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION.getId());

}
