package com.inditex.rrhh.icmclcwb.model.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.GetempleadostiendaOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaRecord;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.mapper.IcmWsIncomeMapper;

// http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop
// @After
@Service
public class Meta4IcmWsIncomeServiceImpl implements Meta4IcmWsIncomeService {
	
	@Autowired
    private Logger LOG;
	
	@Autowired
	@Qualifier("meta4ClientIncome")
	private IcmWsIncomeService meta4ClientIncome;
	
	@Autowired
    private IcmWsIncomeMapper icmWsIncomeMapper;

	@Override
	public boolean obtenerEmpleadosTienda(GetEmpleadosTiendaRequestDTO getEmpleadosTiendaRequestDTO) throws Exception {
		boolean result = false;
		String defaultValue = StringUtils.EMPTY;
		
		IcmParametrospaginacionBlock param1 = icmWsIncomeMapper.asIcmParametrospaginacionBlock(getEmpleadosTiendaRequestDTO.getPage());
		PageDTO param1DTO = icmWsIncomeMapper.asPageDTO(param1);
		LOG.info("param1: " + param1.toString());
		LOG.info("param1DTO: " + param1DTO.toString());
		
		//IcmParametrostiendaBlock param2 = icmWsIncomeMapper.asIcmParametrostiendaBlock(getEmpleadosTiendaRequestDTO.getData());
		
		IcmParametrospaginacionBlock icmParametrospaginacionBlock = new IcmParametrospaginacionBlock();
		icmParametrospaginacionBlock.setIdbusqueda(defaultValue);
		icmParametrospaginacionBlock.setCampoorden(defaultValue);
		icmParametrospaginacionBlock.setNumeropagina("1");
		icmParametrospaginacionBlock.setNumeroregistrospagina("1000");
		icmParametrospaginacionBlock.setNumerototalpaginas(defaultValue);
		icmParametrospaginacionBlock.setNumerototalresultados(defaultValue);
		icmParametrospaginacionBlock.setTipoorden("ASC");
		icmParametrospaginacionBlock.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
		
		IcmParametrostiendaBlock icmParametrostiendaBlock = new IcmParametrostiendaBlock();
		icmParametrostiendaBlock.setFechainicio("2017-09-01T00:00:00.000Z");
		icmParametrostiendaBlock.setFechafin("2017-09-30T00:00:00.000Z");
		icmParametrostiendaBlock.setIdlugartrabajo("T160");
		icmParametrostiendaBlock.setIdestado(defaultValue);
		icmParametrostiendaBlock.setIdestadomtu(defaultValue);
		icmParametrostiendaBlock.getIcmParametrostiendaRecordSet().add(new IcmParametrostiendaRecord());
		
		GetempleadostiendaOutput getempleadostiendaOutput = meta4ClientIncome.getempleadostienda(icmParametrospaginacionBlock, icmParametrostiendaBlock);
		LOG.info("getempleadostiendaOutput.getReturn(): " + getempleadostiendaOutput.getReturn());
		if (getempleadostiendaOutput != null && getempleadostiendaOutput.getIcmEmpleadostienda() != null && getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet() != null && CollectionUtils.isNotEmpty(getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet())) {
			LOG.info("Se han recuperado: " + getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet().size());
			result = true;
		} else {
			LOG.info("No hay elementos");
		}
		return result;
	}

}