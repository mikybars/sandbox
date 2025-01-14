package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrVentaOnlinePickingResultItemDto implements Serializable {

  private static final long serialVersionUID = 6070689891574921909L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer empresa;

  private Integer seccion;

  private Integer tienda;

  @NonNull
  private BigDecimal importeSinIVA;

  @NonNull
  private BigDecimal importeConIVA;

  private String ano;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
