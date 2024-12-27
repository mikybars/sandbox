package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.CadenaVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrVentaOnlineEntregaDomicilioResultItemDto implements Serializable, CadenaVentaResultItemDto {

  private static final long serialVersionUID = -3536933437981318182L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer empresa;

  private Integer seccion;

  private Integer tienda;

  private String ano;

  @NonNull
  private BigDecimal importeSinIVA;

  @NonNull
  private BigDecimal importeConIVA;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
