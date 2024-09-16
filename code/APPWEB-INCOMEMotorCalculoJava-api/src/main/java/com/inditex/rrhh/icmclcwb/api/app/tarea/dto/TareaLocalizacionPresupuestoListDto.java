package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaLocalizacionPresupuestoListDto implements Serializable {

  private static final long serialVersionUID = -2620521240704402267L;

  private List<TareaLocalizacionPresupuestoDto> presupuestos;

  /**
   * Obtiene la menor fecha de inicio entre los presupuestos.
   **
   * @return Fecha de inicio mínima.
   *
   * @deprecated Este método quedará en desuso, usar en su lugar
   *             {@link TareaLocalizacionPresupuestoListDto#getMinFechaInicioPeriodo(LocalDate)}
   */
  @Deprecated
  public LocalDate getMinFechaInicioPeriodo() {
    LocalDate minDate = null;
    if (this.presupuestos != null) {
      minDate = this.getMinFechaInicioPeriodo(LocalDate.now());
    }
    return minDate;
  }

  /**
   * Obtiene la menor fecha de inicio entre los presupuestos y la fecha pasada por parámetro.
   *
   * @param fechaInicioTarea fecha de inicio de la tarea
   * @return fecha de inicio mínima (puede ser la de la tarea o de algún presupuesto)
   */
  public LocalDate getMinFechaInicioPeriodo(final LocalDate fechaInicioTarea) {
    LocalDate minDate = fechaInicioTarea;
    if (this.presupuestos != null) {
      final Optional<TareaLocalizacionPresupuestoDto> optional = this.presupuestos.stream()
          .min(Comparator.comparing(TareaLocalizacionPresupuestoDto::getFechaInicio));
      if (optional.isPresent()) {
        minDate = minDate.isBefore(optional.get().getFechaInicio()) ? minDate : optional.get().getFechaInicio();
      }
    }
    return minDate;
  }

  /**
   * Comprueba si algún presupuesto amplía el rango de fechas de la tarea.
   *
   * @param tarea tarea a comprobar
   * @return <code>true</code> si hay algún presupuesto anterior al rango de fechas de la tarea, <code>false</code> en caso contrario.
   */
  public boolean esAmbitoAmpliado(final TareaDto tarea) {
    final LocalDate minDate = this.getMinFechaInicioPeriodo();
    return minDate != null && minDate.isBefore(tarea.getFechaInicioPeriodo());
  }

}
