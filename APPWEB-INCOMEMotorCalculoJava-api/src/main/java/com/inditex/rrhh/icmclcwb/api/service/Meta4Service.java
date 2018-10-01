package com.inditex.rrhh.icmclcwb.api.service;

public interface Meta4Service {
	
	boolean retrieveM4Session() throws Exception;
	
	boolean login() throws Exception;
	
	boolean obtenerEmpleadosTienda(String idTienda) throws Exception;
    
}