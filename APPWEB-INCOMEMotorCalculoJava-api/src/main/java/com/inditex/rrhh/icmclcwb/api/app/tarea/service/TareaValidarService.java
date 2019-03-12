package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface TareaValidarService {

    List<String> checkDuplicatedEmpleados(@NotNull @Positive Long idTarea);

    List<String> checkDuplicatedTiendas(@NotNull @Positive Long idTarea);
    
    List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea);

    Integer countEmpleados(@NotNull @Positive Long idTarea);

    Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea);

    Integer countTiendas(@NotNull @Positive Long idTarea);

    Integer countTiendasHistorico(@NotNull @Positive Long idTarea);

    Integer countEstructuras(@NotNull @Positive Long idTarea);

    Integer countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea);

    Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea);

    Integer countTiendaVentaSeccion(@NotNull @Positive Long idTarea);


}
