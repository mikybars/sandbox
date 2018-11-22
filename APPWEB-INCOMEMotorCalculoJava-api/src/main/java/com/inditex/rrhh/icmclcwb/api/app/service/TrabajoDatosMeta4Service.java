package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosMeta4Service {

    void condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception;

    void empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception;

    void tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception;

    void tiendasHistorico(@Valid final TrabajoDto trabajo) throws Exception;

}