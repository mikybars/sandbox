package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountrySectionProductHourRequestDto implements Serializable {
    
    private static final long serialVersionUID = 4915131829826736404L;

    private List<Integer> cadena;
    
    private List<Integer> pais;
    
    private String fechaHoraLocalDesde;
    
    private String fechaHoraLocalHasta;
    

}
