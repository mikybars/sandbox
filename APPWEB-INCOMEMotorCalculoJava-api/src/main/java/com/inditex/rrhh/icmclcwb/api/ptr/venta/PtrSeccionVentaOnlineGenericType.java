package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PtrSeccionVentaOnlineGenericType implements Serializable {

  private static final long serialVersionUID = 775015226321738779L;

  private Integer seccion;

  @NotNull
  private BigDecimal importeSinIVA;

  @NotNull
  private BigDecimal importeConIVA;

}
