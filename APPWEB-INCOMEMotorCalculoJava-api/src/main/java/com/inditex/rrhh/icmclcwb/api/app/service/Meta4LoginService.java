package com.inditex.rrhh.icmclcwb.api.app.service;

import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginDto;

public interface Meta4LoginService {
	
	boolean login(LoginDto login) throws Exception;
	
	boolean retrieveM4Session() throws Exception;
    
}