package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.PageDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResponseDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResultItemDTO;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.GetempleadoestructuraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.GetempleadostiendaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.GetvalorescondicionesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrosplantillaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmParametrostiendaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity.IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.mapper.IcmWsIncomeMapper;

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
	public EmpleadosTiendaResponseDTO getEmpleadosTienda(
					EmpleadosTiendaRequestDTO getEmpleadosTiendaRequestDTO) throws Exception {
		EmpleadosTiendaResponseDTO result = new EmpleadosTiendaResponseDTO();

		IcmParametrospaginacionBlock param1 = icmWsIncomeMapper
						.asIcmParametrospaginacionBlock(getEmpleadosTiendaRequestDTO.getPage());
		PageDTO param1DTO = icmWsIncomeMapper.asPageDTO(param1);
		LOG.info("param1: " + param1.toString());
		LOG.info("param1DTO: " + param1DTO.toString());

		IcmParametrostiendaBlock param2 = icmWsIncomeMapper
						.asIcmParametrostiendaBlock(getEmpleadosTiendaRequestDTO.getData());
		EmpleadosTiendaFilterDTO param2DTO = icmWsIncomeMapper.asGetEmpleadosTiendaFilterDTO((param2));
		LOG.info("param2: " + param2.toString());
		LOG.info("param2DTO: " + param2DTO.toString());


		GetempleadostiendaOutput getempleadostiendaOutput = meta4ClientIncome.getempleadostienda(param1, param2);
		LOG.info("getempleadostiendaOutput.getReturn(): " + getempleadostiendaOutput.getReturn());
		if (Double.compare(NumberUtils.DOUBLE_ZERO, getempleadostiendaOutput.getReturn()) == 0
						&& getempleadostiendaOutput != null) {
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
				List<EmpleadosTiendaResultItemDTO> items = icmWsIncomeMapper.asGetEmpleadosTiendaResultDTOs(
								getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet());
				result.setData(items);
			} else {
				LOG.info("No hay elementos");
			}
		} else {
			LOG.error("Ha fallado Meta4");
		}
		return result;
	}

	
	@Override
	public EmpleadosEstructuraResponseDTO getEmpleadosEstructura(EmpleadosEstructuraRequestDTO empleadosEstructuraRequestDTO) throws Exception {
		
		EmpleadosEstructuraResponseDTO result = new EmpleadosEstructuraResponseDTO();
		IcmParametrosempleadoBlock param = icmWsIncomeMapper.asIcmParametrosempleadoBlock(empleadosEstructuraRequestDTO.getData());
		
		GetempleadoestructuraOutput getEmpleadosEstructuraOutput = meta4ClientIncome.getempleadoestructura(param);

		if (Double.compare(NumberUtils.DOUBLE_ZERO, getEmpleadosEstructuraOutput.getReturn()) == 0
				&& getEmpleadosEstructuraOutput != null) {
			if(getEmpleadosEstructuraOutput.getIcmEmpleadosestructura() != null 
					&& getEmpleadosEstructuraOutput.getIcmEmpleadosestructura().getIcmEmpleadosestructuraRecordSet() != null
					&& CollectionUtils.isNotEmpty(getEmpleadosEstructuraOutput.getIcmEmpleadosestructura().getIcmEmpleadosestructuraRecordSet())){
				List<EmpleadosEstructuraResultItemDTO> items = icmWsIncomeMapper.asEmpleadosEstructuraResultItemDTOs(getEmpleadosEstructuraOutput.getIcmEmpleadosestructura().getIcmEmpleadosestructuraRecordSet());
				result.setData(items);
			}
			
		} else {
			LOG.error("Ha fallado Meta4");
		}

		return result;
	}
	
	@Override
	public ValoresCondicionesResponseDTO getValoresCondiciones(ValoresCondicionesRequestDTO valoresCondicionesRequestDTO) throws Exception{
	
		ValoresCondicionesResponseDTO result = new ValoresCondicionesResponseDTO();
		
        IcmParametrosplantillaBlock param = icmWsIncomeMapper
        		.asIcmParametrosplantillaBlock(valoresCondicionesRequestDTO.getData());
		IcmParametrospaginacionBlock param1 = icmWsIncomeMapper
				.asIcmParametrospaginacionBlock(valoresCondicionesRequestDTO.getPage());
        
		GetvalorescondicionesOutput getValoresCondicionesOutput = meta4ClientIncome.getvalorescondiciones(param, param1);

		if (Double.compare(NumberUtils.DOUBLE_ZERO, getValoresCondicionesOutput.getReturn()) == 0
				&& getValoresCondicionesOutput != null) {
			
			if (getValoresCondicionesOutput.getIcmParametrospaginacion() != null) {
				PageDTO page = icmWsIncomeMapper.asPageDTO(getValoresCondicionesOutput.getIcmParametrospaginacion());
				result.setPage(page);
			}
			if(getValoresCondicionesOutput.getIcmPlantillacondiciones() != null 
					&& getValoresCondicionesOutput.getIcmPlantillacondiciones().getIcmPlantillacondicionesRecordSet() != null
					&& CollectionUtils.isNotEmpty(getValoresCondicionesOutput.getIcmPlantillacondiciones().getIcmPlantillacondicionesRecordSet())){
				List<ValoresCondicionesResultItemDTO> items = icmWsIncomeMapper.asValoresCondicionesResultItemDTOs(getValoresCondicionesOutput.getIcmPlantillacondiciones().getIcmPlantillacondicionesRecordSet());
				result.setData(items);
			}
		
		} else {
			LOG.error("Ha fallado Meta4");
		}

		return result;
	}

}