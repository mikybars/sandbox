package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;

public interface TareaValidarRepositoryCustom {

    List<String> checkDuplicatedEmpleados(@NotNull @Positive Long idTarea);

    List<String> checkDuplicatedTiendas(@NotNull @Positive Long idTarea);
    
    List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea);

    List<String> validateAmbitoEmpresa(@NotNull @Positive Long idTarea);

    List<String> validateAmbitoPersona(@NotNull @Positive Long idTarea);

    List<String> validateAmbitoLocalizacion(@NotNull @Positive Long idTarea);
    
    Integer countEmpleados(@NotNull @Positive Long idTarea);

    Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea);

    Integer countTiendas(@NotNull @Positive Long idTarea);

    Integer countTiendasHistorico(@NotNull @Positive Long idTarea);

    Integer countEstructuras(@NotNull @Positive Long idTarea);

    Integer countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea);

    Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea);

    Integer countTiendaVentaSeccion(@NotNull @Positive Long idTarea);

    List<TareaTiendaEstadoDto> tiendaEmptyFields(@NotNull @Positive Long idTarea);

    List<TareaEmpleadoEstadoDto> empleadoEmptyFields(@NotNull @Positive Long idTarea);

    List<TareaPersonaHistoricoDto> empleadoHistoricoEmptyFields(@NotNull @Positive Long idTarea);

}
