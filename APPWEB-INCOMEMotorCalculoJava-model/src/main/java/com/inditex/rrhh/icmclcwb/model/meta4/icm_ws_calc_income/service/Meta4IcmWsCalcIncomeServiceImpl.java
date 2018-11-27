package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.mapper.IcmWsCalcIncomeMapper;

@Service
public class Meta4IcmWsCalcIncomeServiceImpl implements Meta4IcmWsCalcIncomeService {

	@Autowired
	@Qualifier("meta4IcmWsCalcIncomeClient")
	private IcmWsCalcIncomeService meta4IcmWsCalcIncomeClient;
	
    @Autowired
    private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;
	
    @Override
    public TiendasEmpleadoResponseDto getTiendasEmpleado(TiendasEmpleadoRequestDto request) throws Exception {
        TiendasEmpleadoResponseDto result = new TiendasEmpleadoResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasempleadoOutput gettiendasempleadoOutput = meta4IcmWsCalcIncomeClient.gettiendasempleado(param1, param2);
        if (gettiendasempleadoOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, gettiendasempleadoOutput.getReturn()) == 0) {
            if (gettiendasempleadoOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(gettiendasempleadoOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (gettiendasempleadoOutput.getIcmListatiendas() != null
                    && gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<TiendasEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asTiendasEmpleadoResultItemDtos(
                        gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

}