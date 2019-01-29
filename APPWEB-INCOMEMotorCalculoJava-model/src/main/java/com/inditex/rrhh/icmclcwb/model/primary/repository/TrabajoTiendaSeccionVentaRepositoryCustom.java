package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

public interface TrabajoTiendaSeccionVentaRepositoryCustom {

    List<TrabajoTiendaSeccionVenta> save(List<TrabajoTiendaSeccionVenta> src) throws Exception;

}
