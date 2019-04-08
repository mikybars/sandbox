package com.inditex.rrhh.icmclcwb.api.ptr.util;

import java.util.Arrays;
import java.util.List;

public class PtrConstants {
	
    private PtrConstants() {
    }
    
	public static final String PTR_DATE = "yyyy-MM-dd";
	public static final String BOOLEAN_STRING_TRUE = "1";
    public static final String BOOLEAN_STRING_FALSE = "0";
    public static final Integer BOOLEAN_INTEGER_TRUE = 1;
    public static final Integer BOOLEAN_INTEGER_FALSE = 0;
    public static final List<Integer> PRODUCTO_LIST = Arrays.asList(1,2,3,4,5);
    public static final Integer SECCION_1 = 1;
    public static final Integer SECCION_2 = 2;
    public static final Integer SECCION_3 = 3;
	/* CONSTANTES PARA LA LECTURA DE PROPIEDADES DE PTR - VENTAGENERAL*/
    public static final String VENTA_MENSUAL = "getVentaMensual";
    public static final String VENTA_DIARIA = "getVentaDiaria";
    public static final String VENTA_TOTALIZADO = "getVentaTotalizado";
    public static final String VENTA_TOTALIZADO_XML = "getVentaTotalizadoXML";
    public static final String VENTA_TOTALIZADO_BY_MCC = "getVentaTotalizadoByMCC";
    public static final String VENTA_PRESUPUESTADA_MENSUAL = "getVentaPresupuestadaMensual";
    public static final String VENTA_GENERAL_TEST = "test";
    public static final String VENTA_GENERAL_VERSION = "getVersion";

    /* CONSTANTES PARA LA LECTURA DE PROPIEDADES DE PTR - VENTAEMPLEADO*/
    public static final String VENTA_INDIVIDUAL_DETALLE = "getVentaIndividualDetalle";
    public static final String VENTA_INDIVIDUAL_DETALLE_BY_MCC = "getVentaIndividualDetalleByMCC";
    public static final String VENTA_INDIVIDUAL = "getVentaIndividual";
    public static final String VENTA_INDIVIDUAL_BY_MCC = "getVentaIndividualByMCC";
    public static final String VENTA_EMPLEADO_TEST = "test";
    public static final String VENTA_EMPLEADO_VERSION = "getVersion";
    
    /* CONSTANTES PARA LA LECTURA DE PROPIEDADES DE PTR - VENTAECOMMERCE*/
    public static final String VENTA_ONLINE_IPOD = "getVentaOnlineiPod";
    public static final String VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE = "getVentaOnlineIpodIndividualDetalle";
    public static final String VENTA_ONLINE_ENTREGA_TIENDA = "getVentaOnlineEntregaTienda";
    public static final String VENTA_ONLINE_ENTREGA_DOMICILIO = "getVentaOnlineEntregaDomicilio";
    public static final String VENTA_ONLINE_PICKING = "getVentaOnlinePicking";
    public static final String ORDERS_BY_COUNTRY_MINUTE = "getOrdersByCountryMinute";
    public static final String ORDERS_BY_COUNTRY_SECTION_PRODUCT_HOUR = "getOrdersByCountrySectionProductHour";
    public static final String ORDERS_BY_COUNTRY_SECTION_PRODUCT_MINUTE = "getOrdersByCountrySectionProductMinute";
    public static final String ORDERS_BY_COUNTRY_HOUR = "getOrdersByCountryHour";
    public static final String VENTA_ECOMMERCE_TEST = "test";
    public static final String VENTA_ECOMMERCE_VERSION = "getVersion";
    
    /* CONSTANTES PARA LA LECTURA DE PROPIEDADES DE PTR - ACUMULADO*/
    public static final String VENTA_ACUMULADA_DIA = "getVentaAcumDia";
    public static final String VENTA_ACUMULADA = "getVentaAcumUTC";
    public static final String VENTA_ACUMULADA_TEST = "test";
    public static final String VENTA_ACUMULADA_VERSION = "getVersion";
    
    /* CONSTANTES PARA LA LECTURA DE PROPIEDADES DE PTR - PRESENCIAS*/
    public static final String PRESENCIA_TOTAL_TIENDA_SECCION = "getPresenciasTotalTiendaSeccion";
    public static final String PRESENCIA_TOTAL_TIENDA = "getPresenciasTotalTienda";
    public static final String PRESENCIA_DETALLE= "getPresenciasDetalle";
    public static final String PRESENCIA_DETALLE_COMISIONABLE= "getPresenciasDetalleComisionable";
    public static final String PRESENCIA_TIENDAS_EMPLEADO = "getPresenciasTiendasEmpleado";
    public static final String PRESENCIA_EMPLEADOS_TIENDA = "getPresenciasEmpleadosTienda"; 
    public static final String PRESENCIA_TIPOS_HORAS = "getTiposHoras";
    public static final String PRESENCIA_TEST = "test";
    public static final String PRESENCIA_VERSION = "getVersion";

}