package com.inditex.rrhh.icmclcwb.api.service;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login.LoginDTO;

public interface Meta4LoginService {
	
	boolean login(LoginDTO login) throws Exception;
	
	boolean retrieveM4Session() throws Exception;
    
}