package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PtrPresenciaTotalizadoResultItemDto {

  private String fecha;

  private Integer tienda;

  private Integer seccion;

  private Integer origen;

  private Integer empresa;

  private Integer minutos;

  private Integer cadena;

  private Integer gestionLocal;

  private List<PtrSeccionPresenciasGenericType> listaSeccion;

}
