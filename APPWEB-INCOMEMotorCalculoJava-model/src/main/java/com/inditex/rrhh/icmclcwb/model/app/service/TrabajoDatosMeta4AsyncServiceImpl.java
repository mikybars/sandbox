package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4AsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4Service;

@Service
public class TrabajoDatosMeta4AsyncServiceImpl implements TrabajoDatosMeta4AsyncService {

    @Autowired
    private TrabajoDatosMeta4Service trabajoDatosMeta4Service;

    @Async
    @Override
    public CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4Service.empleadosTienda(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasParametro(final TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4Service.tiendasParametro(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4Service.condicionesEmpleados(trabajo);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> tiendasHistorico(TrabajoDto trabajo) throws Exception {
        trabajoDatosMeta4Service.tiendasHistorico(trabajo);
        return CompletableFuture.completedFuture(null);
    }

}