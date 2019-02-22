package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

public interface ProcesoCalculoAlgoritmoGlobalTiendaRepository {

    public void calcularByIdProceso(final Long idProceso);

    public void calcularByIdProcesoAndIdsEmpleado(final Long idProceso, final List<String> idsEmpleado);

}
