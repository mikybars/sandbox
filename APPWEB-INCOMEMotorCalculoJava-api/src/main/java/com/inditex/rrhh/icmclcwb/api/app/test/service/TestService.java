package com.inditex.rrhh.icmclcwb.api.app.test.service;

import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;

public interface TestService {
	
	RelojDto reloj();
	
	SsoDto sso();
	
	void errorSync() throws Exception;
	
	void errorAsync() throws Exception;
	
	void sesion() throws Exception;

}