package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

public interface TrabajoTiendaSeccionVentaRepositoryCustom {

    List<TrabajoTiendaSeccionVenta> saveJdbcTemplate(List<TrabajoTiendaSeccionVenta> src);

    List<TrabajoTiendaSeccionVenta> saveBatch(List<TrabajoTiendaSeccionVenta> src);

    List<TrabajoTiendaSeccionVenta> saveBatchJpa(List<TrabajoTiendaSeccionVenta> src);
}
