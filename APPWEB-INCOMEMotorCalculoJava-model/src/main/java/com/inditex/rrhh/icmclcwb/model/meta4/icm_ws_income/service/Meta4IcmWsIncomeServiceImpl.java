package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;
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
	public EmpleadosTiendaResponseDto getEmpleadosTienda(
					EmpleadosTiendaRequestDto getEmpleadosTiendaRequestDTO) throws Exception {
		EmpleadosTiendaResponseDto result = new EmpleadosTiendaResponseDto();

		IcmParametrospaginacionBlock param1 = icmWsIncomeMapper
						.asIcmParametrospaginacionBlock(getEmpleadosTiendaRequestDTO.getPage());
		PageDto param1DTO = icmWsIncomeMapper.asPageDTO(param1);
		LOG.info("param1: " + param1.toString());
		LOG.info("param1DTO: " + param1DTO.toString());

		IcmParametrostiendaBlock param2 = icmWsIncomeMapper
						.asIcmParametrostiendaBlock(getEmpleadosTiendaRequestDTO.getData());
		EmpleadosTiendaFilterDto param2DTO = icmWsIncomeMapper.asGetEmpleadosTiendaFilterDTO((param2));
		LOG.info("param2: " + param2.toString());
		LOG.info("param2DTO: " + param2DTO.toString());


		GetempleadostiendaOutput getempleadostiendaOutput = meta4ClientIncome.getempleadostienda(param1, param2);
		LOG.info("getempleadostiendaOutput.getReturn(): " + getempleadostiendaOutput.getReturn());
		if (Double.compare(NumberUtils.DOUBLE_ZERO, getempleadostiendaOutput.getReturn()) == 0
						&& getempleadostiendaOutput != null) {
			// Page
			if (getempleadostiendaOutput.getIcmParametrospaginacion() != null) {
				LOG.info("getempleadostiendaOutput.getIcmParametrospaginacion(): {}", getempleadostiendaOutput.getIcmParametrospaginacion());
				PageDto page = icmWsIncomeMapper.asPageDTO(getempleadostiendaOutput.getIcmParametrospaginacion());
				result.setPage(page);
			} else {
				LOG.info("No hay paginacion");
			}
			// Data
			if (getempleadostiendaOutput.getIcmEmpleadostienda() != null
							&& getempleadostiendaOutput.getIcmEmpleadostienda().getIcmEmpleadostiendaRecordSet() != null
							&& CollectionUtils.isNotEmpty(getempleadostiendaOutput.getIcmEmpleadostienda()
											.getIcmEmpleadostiendaRecordSet())) {
				LOG.info("Se han recuperado: " + getempleadostiendaOutput.getIcmEmpleadostienda()
								.getIcmEmpleadostiendaRecordSet().size());
				List<EmpleadosTiendaResultItemDto> items = icmWsIncomeMapper.asGetEmpleadosTiendaResultDTOs(
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
	public EmpleadosEstructuraResponseDto getEmpleadosEstructura(EmpleadosEstructuraRequestDto empleadosEstructuraRequestDTO) throws Exception {
		
		EmpleadosEstructuraResponseDto result = new EmpleadosEstructuraResponseDto();
		IcmParametrosempleadoBlock param = icmWsIncomeMapper.asIcmParametrosempleadoBlock(empleadosEstructuraRequestDTO.getData());
		
		GetempleadoestructuraOutput getEmpleadosEstructuraOutput = meta4ClientIncome.getempleadoestructura(param);

		if (Double.compare(NumberUtils.DOUBLE_ZERO, getEmpleadosEstructuraOutput.getReturn()) == 0
				&& getEmpleadosEstructuraOutput != null) {
			if(getEmpleadosEstructuraOutput.getIcmEmpleadosestructura() != null 
					&& getEmpleadosEstructuraOutput.getIcmEmpleadosestructura().getIcmEmpleadosestructuraRecordSet() != null
					&& CollectionUtils.isNotEmpty(getEmpleadosEstructuraOutput.getIcmEmpleadosestructura().getIcmEmpleadosestructuraRecordSet())){
				List<EmpleadosEstructuraResultItemDto> items = icmWsIncomeMapper.asEmpleadosEstructuraResultItemDTOs(getEmpleadosEstructuraOutput.getIcmEmpleadosestructura().getIcmEmpleadosestructuraRecordSet());
				result.setData(items);
			}
			
		} else {
			LOG.error("Ha fallado Meta4");
		}

		return result;
	}
	
	@Override
	public ValoresCondicionesResponseDto getValoresCondiciones(ValoresCondicionesRequestDto valoresCondicionesRequestDTO) throws Exception{
	
		ValoresCondicionesResponseDto result = new ValoresCondicionesResponseDto();
		
        IcmParametrosplantillaBlock param = icmWsIncomeMapper
        		.asIcmParametrosplantillaBlock(valoresCondicionesRequestDTO.getData());
		IcmParametrospaginacionBlock param1 = icmWsIncomeMapper
				.asIcmParametrospaginacionBlock(valoresCondicionesRequestDTO.getPage());
        
		GetvalorescondicionesOutput getValoresCondicionesOutput = meta4ClientIncome.getvalorescondiciones(param, param1);

		if (Double.compare(NumberUtils.DOUBLE_ZERO, getValoresCondicionesOutput.getReturn()) == 0
				&& getValoresCondicionesOutput != null) {
			
			if (getValoresCondicionesOutput.getIcmParametrospaginacion() != null) {
				PageDto page = icmWsIncomeMapper.asPageDTO(getValoresCondicionesOutput.getIcmParametrospaginacion());
				result.setPage(page);
			}
			if(getValoresCondicionesOutput.getIcmPlantillacondiciones() != null 
					&& getValoresCondicionesOutput.getIcmPlantillacondiciones().getIcmPlantillacondicionesRecordSet() != null
					&& CollectionUtils.isNotEmpty(getValoresCondicionesOutput.getIcmPlantillacondiciones().getIcmPlantillacondicionesRecordSet())){
				List<ValoresCondicionesResultItemDto> items = icmWsIncomeMapper.asValoresCondicionesResultItemDTOs(getValoresCondicionesOutput.getIcmPlantillacondiciones().getIcmPlantillacondicionesRecordSet());
				result.setData(items);
			}
		
		} else {
			LOG.error("Ha fallado Meta4");
		}

		return result;
	}

}