package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountryMinuteRequestDto implements Serializable {
    
    private static final long serialVersionUID = -4166360361362549676L;
 
    private List<Integer> cadena;
    
    private List<Integer> pais;

    private String fechaHoraMinutoLocalDesde;
    
    private String fechaHoraMinutoLocalHasta;
    

}
