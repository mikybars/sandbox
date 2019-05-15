package com.inditex.rrhh.icmclcwb.api.app.test.service;

import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;

public interface TestService {
	
	RelojDto reloj();
	
	SsoDto sso();
	
	void errorSync();
	
	void errorAsync();
	
	void sesion();
	
	void trabajoFase1a();

}