package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoCustomRepository;

@Service
@Validated
public class TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeService {

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TrabajoTiendaEstadoAsyncService trabajoTiendaEstadoAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEstadoMapper trabajotiendaEstadoMapper;

    @Autowired
    private TrabajoTiendaEstadoCustomRepository trabajoTiendaEstadoCustomRepository;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @AuditoriaTrabajo
    @Override
    public void tiendasEmpleado(@Valid final TrabajoDto trabajo) throws Exception {

        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            trabajo.getTrabajoRunDatos().setTiendasPresenciaNuevas(trabajoTiendaEstadoCustomRepository
                    .customFindByIdTiendaNotExists(trabajo.getTrabajoRunDatos().getTiendasPresencia()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);
            TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
            tiendasEmpleadoRequest.setPage(getEmpleadosTiendaDto.getPage());
            tiendasEmpleadoRequest.setData(filter);
            boolean hasNext = false;
            do {
                // Consultamos en meta4 los empleados por tienda de forma paginada.
                CompletableFuture<List<TiendasEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
                        .getTiendasEmpleado(tiendasEmpleadoRequest);
                AsyncUtils.exceptionally(cfData, cf);

                List<TiendasEmpleadoResultItemDto> data = cfData.get();
                if (CollectionUtils.isNotEmpty(data)) {
                    /*-------------------------------------------------------------*/
                    trabajo.getTrabajoRunDatosAuditoria().setTiendasPresencia(
                            trabajo.getTrabajoRunDatosAuditoria().getTiendasPresencia() + data.size());
                    /*-------------------------------------------------------------*/
                    List<TrabajoTiendaEstadoDto> trabajoEmpleadoEstado = trabajotiendaEstadoMapper
                            .tiendasEmpleadoResultItemDtoToTrabajoTiendaEstadoDto(data);
                    if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                getEmpleadosTiendaDto.getFilter().getMaxPersistenceSize());
                        CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoEmpleadoEstado,
                                trabajo);
                        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                    }
                }
                hasNext = tiendasEmpleadoRequest.nextPage();
            } while (hasNext);

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }
}