package com.inditex.rrhh.icmclcwb.model.app.calcular;

/**
 * Factory interface for creating non-blocking validation instances.
 */
public interface RunValidacionNoBloqueanteFactory {

  /**
   * Get a non-blocking validation instance by name.
   *
   * @param type The name/type of the validation (e.g., "validarCalculoPendienteV1")
   * @return The validation instance
   */
  RunValidacionNoBloqueante getRunValidacionNoBloqueante(String type);

}
