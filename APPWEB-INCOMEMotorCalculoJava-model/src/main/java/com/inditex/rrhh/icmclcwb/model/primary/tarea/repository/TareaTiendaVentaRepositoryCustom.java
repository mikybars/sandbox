package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVenta;

public interface TareaTiendaVentaRepositoryCustom {

    List<TareaTiendaVenta> save(List<TareaTiendaVenta> src);
    
}
