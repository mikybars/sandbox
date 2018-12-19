package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

public interface TrabajoTiendaSeccionVentaRepositoryCustom {

//    List<TrabajoTiendaSeccionVenta> saveJdbcTemplate(List<TrabajoTiendaSeccionVenta> src) throws Exception;

    List<TrabajoTiendaSeccionVenta> save(List<TrabajoTiendaSeccionVenta> src) throws Exception;

//    List<TrabajoTiendaSeccionVenta> saveJpaBatch(List<TrabajoTiendaSeccionVenta> src) throws Exception;

}
