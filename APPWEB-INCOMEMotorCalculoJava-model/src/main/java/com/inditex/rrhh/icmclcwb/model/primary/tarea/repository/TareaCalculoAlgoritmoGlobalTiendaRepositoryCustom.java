package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;

public interface TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom {

    public void calcularByIdTarea(final Long idTarea, final AlgoritmoDto algoritmo);

    public void calcularByIdTareaAndIdsEmpleado(final Long idTarea, final AlgoritmoDto algoritmo,
            final List<String> idsEmpleado);

}
