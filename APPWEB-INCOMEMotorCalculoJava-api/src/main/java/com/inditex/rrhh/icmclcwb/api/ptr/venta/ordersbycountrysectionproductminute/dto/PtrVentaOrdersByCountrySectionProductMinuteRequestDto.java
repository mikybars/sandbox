package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountrySectionProductMinuteRequestDto implements Serializable {
    
    private static final long serialVersionUID = -1029372012772098588L;

    private List<Integer> cadena;
    
    private List<Integer> pais;
    
    private String fechaHoraMinutoLocalDesde;
    
    private String fechaHoraMinutoLocalHasta;
    

}
