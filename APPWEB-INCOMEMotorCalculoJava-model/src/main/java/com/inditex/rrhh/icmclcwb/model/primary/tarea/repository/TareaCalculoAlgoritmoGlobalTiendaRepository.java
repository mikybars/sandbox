package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

public interface TareaCalculoAlgoritmoGlobalTiendaRepository {

    public void calcularByIdTarea(final Long idTarea, final Long idAlgoritmo);

    public void calcularByIdTareaAndIdsEmpleado(final Long idTarea, final List<String> idsEmpleado, final Long idAlgoritmo);

}
