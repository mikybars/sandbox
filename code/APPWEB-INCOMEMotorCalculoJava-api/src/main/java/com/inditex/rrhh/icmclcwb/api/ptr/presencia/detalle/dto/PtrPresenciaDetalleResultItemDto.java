package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto;

import java.io.Serializable;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class PtrPresenciaDetalleResultItemDto implements Serializable {

  private static final long serialVersionUID = -2286264737159679411L;

  @NonNull
  private Integer tienda;

  private Integer seccion;

  @NonNull
  private Integer persona;

  @NotBlank
  private String fecha;

  private Integer minutos;

  private Integer tipo;

  private Integer cadena;

  private Integer origen;

  private Integer empresa;

  private Integer gestionLocal;

  private List<PtrSeccionPresenciasGenericType> listaSeccion;

}
