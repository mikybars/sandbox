package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

@Service
public class TareaTiendaPresenciaSeccionAsyncServiceImpl implements TareaTiendaPresenciaSeccionAsyncService {

    @Autowired
    private TareaTiendaPresenciaSeccionService tareaTiendaPresenciaSeccionService;
    
    @Deprecated
    @Override
    public CompletableFuture<Void> pivot(final TareaDto tarea)  {
        tareaTiendaPresenciaSeccionService.pivot(tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    
    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TareaDto tarea) {
        tareaTiendaPresenciaSeccionService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
