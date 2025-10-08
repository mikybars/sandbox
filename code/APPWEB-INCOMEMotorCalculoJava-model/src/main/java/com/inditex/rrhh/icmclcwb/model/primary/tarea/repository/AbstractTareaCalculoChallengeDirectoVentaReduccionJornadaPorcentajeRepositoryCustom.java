package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;

/**
 * Clase base abstracta que implementa el Template Method Pattern para reducir la duplicación de código entre los repositorios de algoritmos
 * Challenge Directo Venta con Reducción de Jornada por Porcentaje. Esta clase centraliza toda la lógica común y permite que las clases
 * hijas solo implementen sus particularidades específicas.
 */
public abstract class AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom {

  /**
   * Template Method: Define el algoritmo completo para construir el Map de parámetros SQL. Las subclases solo necesitan implementar la
   * parte específica.
   *
   * @param algoritmo el algoritmo con sus configuraciones
   * @param tarea la tarea asociada
   * @param persona la persona para la cual calcular
   * @return mapa con todos los parámetros SQL necesarios
   */
  @Override
  protected final Map<String, Object> getMapValues(AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    // Construir el mapa con valores comunes (Template Method - parte fija)
    final Map<String, Object> map = this.buildCommonMapValues(algoritmo, tarea, persona);

    // Permitir que cada subclase agregue sus valores específicos (Template Method - parte variable)
    this.addSpecificMapValues(map, algoritmo, tarea, persona);

    return map;
  }

  /**
   * Construye todos los valores comunes del Map. Este metodo es privado y no puede ser sobrescrito, garantizando consistencia.
   *
   * @param algoritmo el algoritmo con sus configuraciones
   * @param tarea la tarea asociada
   * @param persona la persona para la cual calcular
   * @return mapa con los parámetros SQL comunes
   */
  private Map<String, Object> buildCommonMapValues(AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    final Map<String, Object> map = new HashMap<>();

    // Parámetros de tarea y persona
    if (tarea != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    }
    if (persona != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    }

    // Parámetros del algoritmo
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());

    // Parámetros booleanos comunes
    map.put(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.put(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    // Parámetros de tipos de comisión y cálculo del algoritmo
    map.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION,
        algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).toList());
    map.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
        algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).toList());

    // Parámetros de configuración de desplazamiento
    map.put(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO, Boolean.TRUE.equals(algoritmo.getDesplazamiento())
        ? SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE
        : SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.put(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE, Boolean.TRUE.equals(algoritmo.getDesplazamientoBase())
        ? SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE
        : SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

    return map;
  }

  /**
   * Hook Method: Permite a cada subclase agregar sus parámetros específicos al Map. Por defecto no hace nada - las subclases pueden
   * sobrescribir este metodo solo si necesitan agregar parámetros específicos adicionales.
   *
   * @param map el mapa al cual agregar parámetros específicos (ya contiene los comunes)
   * @param algoritmo el algoritmo con sus configuraciones
   * @param tarea la tarea asociada
   * @param persona la persona para la cual calcular
   */
  protected void addSpecificMapValues(Map<String, Object> map, AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    // Implementación por defecto vacía
  }
}
