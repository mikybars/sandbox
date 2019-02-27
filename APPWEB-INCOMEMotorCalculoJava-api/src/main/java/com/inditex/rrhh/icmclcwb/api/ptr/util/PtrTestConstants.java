package com.inditex.rrhh.icmclcwb.api.ptr.util;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;

public class PtrTestConstants {

    private PtrTestConstants() {
    }

    public static final String FECHA_DESDE = "2017-12-01";

    public static final String FECHA_HASTA = "2017-12-31";
    
    public static final String FECHA_HORA_DESDE = "2017-12-01 00:00";

    public static final String FECHA_HORA_HASTA = "2017-12-31 00:00";

    public static final List<Integer> PAIS_LIST = Arrays.asList(11);

    public static final List<Integer> CADENA_LIST = Arrays.asList(1);
    
    public static final List<Integer> PERSONA_LIST = Arrays.asList(1645, 1000);
    
    public static final List<Integer> TIPO_LIST = Arrays.asList(1000);
    
    public static final List<Integer> ORIGEN_LIST = Arrays.asList(11);
    
    public static final Integer ORIGEN = 11;
    
    public static final Integer PAIS = 11;

    public static final Integer CADENA = 1;

    public static final Integer ID_TIENDA = 57;
    
    public static final List<Integer> ID_TIENDA_LIST = Arrays.asList(57);

    public static final List<Integer> ID_TIPO_SECCION = Arrays.asList(1);

    public static final Integer ID_EJERCICIO = 1;
    
    
    public static final Integer TIPO = 1;
    
    public static final Integer SECCION = 1;
    
    public static final PtrPresenciaTiendaSeccionDto TIENDA_SECCION_1 = new PtrPresenciaTiendaSeccionDto(2, null);
    
    public static final PtrPresenciaTiendaSeccionDto TIENDA_SECCION_2 = new PtrPresenciaTiendaSeccionDto(150, null);

    
    


}
