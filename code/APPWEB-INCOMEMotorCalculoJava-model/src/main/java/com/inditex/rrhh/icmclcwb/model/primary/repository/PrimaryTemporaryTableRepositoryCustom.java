package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.constraints.NotNull;

public interface PrimaryTemporaryTableRepositoryCustom {

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempComisHistorico();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempComisHistorico();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempComisHistorico(List<IdPersonaLocalCondicionesDto> listado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeDateRangesTempComisHistorico(final TareaDto tarea);

  List<IdPersonaLocalDto> validateTempComisChallengePorcentaje(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempComisDesplazamiento();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempComisDesplazamiento();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempComisDesplazamiento(List<IdPersonaLocalCondicionesDto> listado);

  int desactivaFechasSolapadas();

  void reactivaFechasSolapadas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempComisResalta();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempComisResalta();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempComisResalta(List<IdPersonaLocalCondicionesDto> listado);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempComisBajaIt();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempComisBajaIt();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempComisBajaIt(List<IdPersonaLocalCondicionesDto> listado);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempComisCarencia();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempComisCarencia();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempComisCarencia(List<IdPersonaLocalCarenciaDto> listado);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempMotivoDesplazamientoComis();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempMotivoDesplazamientoComis();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempMotivoDesplazamientoComis(List<IdMotivoDesplazamientoDto> listado);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempMotivoDesplazamientoMeta4();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempMotivoDesplazamientoMeta4();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempMotivoDesplazamientoMeta4(List<IdMotivoDesplazamientoDto> listado);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  List<IdMotivoDesplazamientoDto> validateTempMotivoDesplazamiento();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  List<IdPersonaLocalDto> validateTempComisBajaIt(@NotNull TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  List<IdPersonaLocalDto> validateTempComisCarencia(@NotNull TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalDto> validateTempComisHistorico(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalDto> validateTempComisDesplazamiento(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalDto> validateTempComisResalta(TareaDto tarea);

  /**
   * Comprueba las diferencias de comisiones manuales entre comis e income.
   *
   * @param tarea tarea.
   * @return Empleados cuyas comisiones manuales difieren.
   */
  List<IdPersonaLocalDto> validateTempComisComisionManual(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeDateRangesSeccionNotEqualsTempComisHistorico(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempAlgoritmo();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempAlgoritmo();

  /**
   * Some javadoc.
   *
   * @param algoritmoDto Some javadoc.
   */
  void insertTempAlgoritmo(@NotNull List<GenericAlgoritmoPropertiesDto> algoritmoDto);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempAlgoritmo();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempEstructura();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempEstructura();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempEstructura();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempPersonas();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempPersonas();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempPersonas();

  /**
   * Some javadoc.
   */
  void insertTempPersonas();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempPresupuestos();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempPresupuestos();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempPresupuestos();

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void insertTempPresupuestos(@NotNull TareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void insertTempEstructura(@NotNull TareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param tareaDto Some javadoc.
   */
  void insertTareaLocalizacionPresupuestoTareaPersonaEstructura(@NotNull TareaDto tareaDto);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeDateRangesSeccionNotEqualsTempComisResalta(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeDateRangesTempComisResalta(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempComisPrimas();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempComisPrimas();

  /**
   * Some javadoc.
   *
   * @param listado Some javadoc.
   */
  void insertTempComisPrimas(List<IdPersonaLocalCondicionesDto> listado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeDateRangesSeccionNotEqualsTempComisPrimas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeDateRangesTempComisPrimas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return lista de personas que no coinciden en COMIS e INCOME
   */
  List<IdPersonaLocalDto> validateTempComisPrimas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempCalculoPorComision();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempCalculoPorComision();

  /**
   * Totaliza los valores de TAREA_CALCULO del período por persona y tipo comisón.
   *
   * @param tarea Some javadoc.
   */
  void mergeCalculoTempCalculoPorComision(TareaDto tarea);

  /**
   * Totaliza los valores de TAREA_CALCULO del período por persona. El tipo de comisión lo deja a nulo.
   *
   * @param tarea Some javadoc.
   */
  void mergeCalculoTempCalculoSinComision(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempCalculoAjusteTotalizado();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempCalculoAjusteTotalizado();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void mergeCalculoTempCalculoAjusteTotalizado(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempMejorOpcion();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempMejorOpcion();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempMejorOpcion();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void insertTempMejorOpcion(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempMejorOpcionSinFechas();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempMejorOpcionSinFechas();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempMejorOpcionSinFechas();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void insertTempMejorOpcionSinFechas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempMejorOpcionSinFechasTodoPeriodo();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempMejorOpcionSinFechasTodoPeriodo();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempMejorOpcionSinFechasTodoPeriodo();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void insertTempMejorOpcionSinFechasTodoPeriodo(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempBandasOrigenSinBandaDesplazamiento();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void insertBandasOrigenSinBandaDesplazamiento(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempBandasOrigenSinBandaDesplazamiento();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempEstructurasBaseChallenge();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempEstructurasBaseChallenge();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempEstructurasBaseChallenge();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void insertTempEstructurasBaseChallenge(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int deleteTempEstructurasDesplazamientoNoChallenge();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int createTempEstructurasDesplazamientoNoChallenge();

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int indexTempEstructurasDesplazamientoNoChallenge();

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   */
  void insertTempEstructurasDesplazamientoNoChallenge(TareaDto tarea);

  /**
   * Elimina la tabla temporal de comisiones manuales.
   *
   * @return Some javadoc.
   */
  int deleteTempComisComisionManual();

  /**
   * Crea la tabla temporal de comisiones manuales.
   *
   * @return Some javadoc.
   */
  int createTempComisComisionManual();

  /**
   * Crea un índice para la tabla temporal de comisiones manuales.
   *
   * @return Some javadoc.
   */
  int indexTempComisComisionManual();

  /**
   * Inserta la información de las comisiones manuales en la tabla temporal.
   *
   * @param comisiones Comisiones manuales a insertar.
   */
  void insertTempComisComisionManual(List<IdPersonaLocalComisionManualDto> comisiones);

  /**
   * Elimina la tabla temporal de personas relacionadas con sus tiendas de la posición.
   *
   * @return Some javadoc.
   */
  int deleteTempComisPersonasLocalizaciones();

  /**
   * Crea la tabla temporal de personas relacionadas con sus tiendas de la posición.
   *
   * @return Some javadoc.
   */
  int createTempComisPersonasLocalizaciones();

  /**
   * Crea un índice para la tabla temporal de personas relacionadas con sus tiendas de la posición.
   *
   * @return Some javadoc.
   */
  int indexTempComisPersonasLocalizaciones();

  /**
   * Inserta la información de las personas en la tabla temporal.
   *
   * @param personas Personas a insertar.
   */
  void insertTempComisPersonasLocalizaciones(List<IdPersonaLocalLocalizacionDto> personas);

  /**
   * Comprueba las diferencias de personas entre comis e income.
   *
   * @param tarea tarea.
   * @return Empleados que aparecen en comis y no en income.
   */
  List<IdPersonaLocalDto> validateTempComisPersonas(TareaDto tarea);

  List<IdPersonaLocalDto> validateTempComisDesplazamientoChallengePorcentaje(TareaDto tarea);

}
