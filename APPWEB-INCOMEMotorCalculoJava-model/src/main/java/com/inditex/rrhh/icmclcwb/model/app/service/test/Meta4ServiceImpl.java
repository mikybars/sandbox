package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.util.annotation.Meta4Session;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;

@Service
public class Meta4ServiceImpl implements Meta4Service {

	//TODO DTENREIRO
//	@Autowired
//	private ApplicationContext appContext;
	
	@Autowired
	private Meta4IcmWsIncomeService meta4IcmWsIncomeService;

	@Meta4Session
	@Override
	public List<GetEmpleadosTiendaResultItemDTO> obtenerEmpleadosTienda(String idTienda) throws Exception {
		List<GetEmpleadosTiendaResultItemDTO> result = new ArrayList<>();

		GetEmpleadosTiendaRequestDTO param = new GetEmpleadosTiendaRequestDTO();
		PageDTO page = new PageDTO();
		page.setIdBusqueda(StringUtils.EMPTY);
		page.setCampoOrden("idempleado");
		page.setNumeroPagina(1);
		page.setNumeroRegistrosPagina(10);
		page.setNumeroTotalPaginas(null);
		page.setNumeroTotalResultados(null);
		page.setTipoOrden("DESC");
		param.setPage(page);

		GetEmpleadosTiendaFilterDTO data = new GetEmpleadosTiendaFilterDTO();
		data.setFechaInicio(LocalDateTime.of(2017, Month.SEPTEMBER, 01, 00, 00));
		data.setFechaFin(LocalDateTime.of(2017, Month.SEPTEMBER, 01, 00, 00).with(TemporalAdjusters.lastDayOfMonth()));
		data.setIdLugarTrabajo(idTienda);
		data.setIdEstado(StringUtils.EMPTY);
		data.setIdEstadoMtu(StringUtils.EMPTY);
		param.setData(data);

		boolean hasNext = false;
		do {
			hasNext = false;
			GetEmpleadosTiendaResponseDTO response = meta4IcmWsIncomeService.obtenerEmpleadosTienda(param);
			if (response != null) {
				if (CollectionUtils.isNotEmpty(response.getData())) {
					result.addAll(response.getData());
				}
				if (response.getPage() != null && response.getPage().hasNext()) {
					hasNext = true;
					param.setPage(response.getPage().next());
				}
			}
		} while (hasNext);
		
		return result;
	}

}