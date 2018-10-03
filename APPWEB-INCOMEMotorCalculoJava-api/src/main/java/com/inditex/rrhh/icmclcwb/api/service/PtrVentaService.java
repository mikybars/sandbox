package com.inditex.rrhh.icmclcwb.api.service;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login.LoginDTO;

public interface PtrVentaService {
	
	///ventaGeneralService/getVentaTotalizado
	//http://axdesptrosb01-vip.central.inditex.grp:33813/OFDAVTIMPADWSD/service/ventaGeneral/getVentaTotalizado
	boolean getVentaTotalizado(LoginDTO login) throws Exception;
    
}