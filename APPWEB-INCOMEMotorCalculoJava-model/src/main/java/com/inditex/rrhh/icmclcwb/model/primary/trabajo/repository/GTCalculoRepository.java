package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

public interface GTCalculoRepository {

    public void calcularByIdTrabajo(final Long idTrabajo);

    public void calcularByIdTrabajoAndIdsEmpleado(final Long idTrabajo, final List<String> idsEmpleado);

}
