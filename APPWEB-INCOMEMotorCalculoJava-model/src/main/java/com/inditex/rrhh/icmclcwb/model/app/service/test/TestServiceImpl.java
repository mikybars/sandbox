package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestServiceImpl implements TestService {

	@Autowired
	private Logger LOG;

	@Override
	public RelojDto reloj() {
		return new RelojDto();
	}

	@Override
	public SsoDto sso() {
		SsoDto result = new SsoDto();
		UserSSO userSso = SsoUtils.getUserSSO();
		LOG.info("userSso: {}", userSso);
		result.setResult(userSso.toString());
		return result;
	}

}