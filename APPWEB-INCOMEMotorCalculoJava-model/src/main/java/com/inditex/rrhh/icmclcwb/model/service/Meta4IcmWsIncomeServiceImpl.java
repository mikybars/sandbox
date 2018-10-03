package com.inditex.rrhh.icmclcwb.model.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.GetempleadostiendaOutput;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaBlock;
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
	public GetEmpleadosTiendaResponseDTO obtenerEmpleadosTienda(GetEmpleadosTiendaRequestDTO getEmpleadosTiendaRequestDTO) throws Exception {
		GetEmpleadosTiendaResponseDTO result = new GetEmpleadosTiendaResponseDTO();

		IcmParametrospaginacionBlock param1 = icmWsIncomeMapper
						.asIcmParametrospaginacionBlock(getEmpleadosTiendaRequestDTO.getPage());
		PageDTO param1DTO = icmWsIncomeMapper.asPageDTO(param1);
		LOG.info("param1: " + param1.toString());
		LOG.info("param1DTO: " + param1DTO.toString());

		IcmParametrostiendaBlock param2 = icmWsIncomeMapper
						.asIcmParametrostiendaBlock(getEmpleadosTiendaRequestDTO.getData());
		GetEmpleadosTiendaFilterDTO param2DTO = icmWsIncomeMapper.asGetEmpleadosTiendaFilterDTO((param2));
		LOG.info("param2: " + param2.toString());
		LOG.info("param2DTO: " + param2DTO.toString());

		// String defaultValue = StringUtils.EMPTY;
		// IcmParametrospaginacionBlock icmParametrospaginacionBlock = new
		// IcmParametrospaginacionBlock();
		// icmParametrospaginacionBlock.setIdbusqueda(defaultValue);
		// icmParametrospaginacionBlock.setCampoorden(defaultValue);
		// icmParametrospaginacionBlock.setNumeropagina("1");
		// icmParametrospaginacionBlock.setNumeroregistrospagina("1000");
		// icmParametrospaginacionBlock.setNumerototalpaginas(defaultValue);
		// icmParametrospaginacionBlock.setNumerototalresultados(defaultValue);
		// icmParametrospaginacionBlock.setTipoorden("ASC");
		// icmParametrospaginacionBlock.getIcmParametrospaginacionRecordSet().add(new
		// IcmParametrospaginacionRecord());
		//
		// IcmParametrostiendaBlock icmParametrostiendaBlock = new
		// IcmParametrostiendaBlock();
		// icmParametrostiendaBlock.setFechainicio("2017-09-01T00:00:00.000Z");
		// icmParametrostiendaBlock.setFechafin("2017-09-30T00:00:00.000Z");
		// icmParametrostiendaBlock.setIdlugartrabajo("T160");
		// icmParametrostiendaBlock.setIdestado(defaultValue);
		// icmParametrostiendaBlock.setIdestadomtu(defaultValue);
		// icmParametrostiendaBlock.getIcmParametrostiendaRecordSet().add(new
		// IcmParametrostiendaRecord());
		//
		// GetempleadostiendaOutput getempleadostiendaOutput =
		// meta4ClientIncome.getempleadostienda(icmParametrospaginacionBlock,
		// icmParametrostiendaBlock);

		GetempleadostiendaOutput getempleadostiendaOutput = meta4ClientIncome.getempleadostienda(param1, param2);
		LOG.info("getempleadostiendaOutput.getReturn(): " + getempleadostiendaOutput.getReturn());
		if (Double.compare(NumberUtils.DOUBLE_ZERO, getempleadostiendaOutput.getReturn()) == 0 && getempleadostiendaOutput != null) {
			// Page
			if (getempleadostiendaOutput.getIcmParametrospaginacion() != null) {
				PageDTO page = icmWsIncomeMapper.asPageDTO(getempleadostiendaOutput.getIcmParametrospaginacion());
				result.setPage(page);
			}
			// Data
			if (getempleadostiendaOutput.getIcmEmpleadostienda() != null
							&& getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet() != null
							&& CollectionUtils.isNotEmpty(getempleadostiendaOutput.getIcmEmpleadostienda()
											.getIcmEmpleadostiendaRecordSet())) {
				LOG.info("Se han recuperado: " + getempleadostiendaOutput.getIcmEmpleadostienda()
								.getIcmEmpleadostiendaRecordSet().size());
				List<GetEmpleadosTiendaResultItemDTO> items = icmWsIncomeMapper.asGetEmpleadosTiendaResultDTOs(getempleadostiendaOutput.getIcmEmpleadostienda()
								.getIcmEmpleadostiendaRecordSet());
				result.setData(items);
			} else {
				LOG.info("No hay elementos");
			}
		} else {
			LOG.error("Ha fallado Meta4");
		}
		return result;
	}

}