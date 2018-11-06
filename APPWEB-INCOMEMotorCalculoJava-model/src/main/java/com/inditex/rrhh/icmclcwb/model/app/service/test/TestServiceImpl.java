package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestServiceImpl implements TestService {

	@Override
	public RelojDto reloj() {
		return new RelojDto();
	}

	@Override
	public SsoDto sso() {
		return new SsoDto();
	}

}