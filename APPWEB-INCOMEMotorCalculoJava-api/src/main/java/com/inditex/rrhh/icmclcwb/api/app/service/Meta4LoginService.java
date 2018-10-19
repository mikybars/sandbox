package com.inditex.rrhh.icmclcwb.api.app.service;

import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginRequestDto;

public interface Meta4LoginService {
	
	boolean login(LoginRequestDto login) throws Exception;
	
	boolean retrieveM4Session() throws Exception;
	
	boolean logout();
    
}