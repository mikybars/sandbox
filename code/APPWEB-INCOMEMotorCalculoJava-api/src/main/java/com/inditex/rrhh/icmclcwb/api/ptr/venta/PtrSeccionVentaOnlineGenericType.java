package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PtrSeccionVentaOnlineGenericType implements Serializable {

  private static final long serialVersionUID = 775015226321738779L;

  private Integer seccion;

  @NonNull
  private Double importeSinIVA;

  @NonNull
  private Double importeConIVA;

}
