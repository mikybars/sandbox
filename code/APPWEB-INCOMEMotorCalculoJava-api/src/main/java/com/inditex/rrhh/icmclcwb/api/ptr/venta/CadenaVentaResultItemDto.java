package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.math.BigDecimal;

public interface CadenaVentaResultItemDto {

  Integer getCadena();

  BigDecimal getImporteSinIVA();

  BigDecimal getImporteConIVA();

  String getFecha();

  Integer getSeccion();

  Integer getPais();

}
