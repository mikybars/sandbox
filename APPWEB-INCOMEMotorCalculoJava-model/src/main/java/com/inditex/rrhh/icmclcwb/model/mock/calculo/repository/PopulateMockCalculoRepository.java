package com.inditex.rrhh.icmclcwb.model.mock.calculo.repository;

import java.util.List;

import org.springframework.core.io.Resource;


public interface PopulateMockCalculoRepository {

	public void loadScripts(List<Resource> scripts);
}
