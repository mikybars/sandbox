package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoTiendaHistoricoAsyncServiceImpl implements ProcesoTiendaHistoricoAsyncService {

	@Autowired
	private ProcesoTiendaHistoricoService procesoTiendaHistoricoService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico, final ProcesoDto proceso) {
    	procesoTiendaHistoricoService.save(procesoTiendaHistorico, proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
