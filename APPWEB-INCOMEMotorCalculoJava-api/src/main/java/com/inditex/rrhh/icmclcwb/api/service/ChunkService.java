package com.inditex.rrhh.icmclcwb.api.service;

import java.util.concurrent.CompletableFuture;

public interface ChunkService {
    
	CompletableFuture<Boolean> obtenerEmpleadosTienda(String idTienda);
	
}