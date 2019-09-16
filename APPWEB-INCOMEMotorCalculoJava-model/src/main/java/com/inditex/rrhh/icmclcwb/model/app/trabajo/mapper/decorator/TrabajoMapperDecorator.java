package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoEjecucionCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public abstract class TrabajoMapperDecorator extends TrabajoMapper {

    @Autowired
    private TrabajoMapper delegate;

    @Autowired
    private TrabajoAmbitoOrigenMapper trabajoAmbitoOrigenMapper;

    @Autowired
    private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

    @Autowired
    private TrabajoAmbitoLocalizacionMapper trabajoAmbitoLocalizacionMapper;

    @Autowired
    private TrabajoAmbitoPersonaMapper trabajoAmbitoPersonaMapper;

    @Override
    public SaveProcesoDto trabajoDtoToSaveProcesoDto(TrabajoDto trabajo) {
        SaveProcesoDto result = delegate.trabajoDtoToSaveProcesoDto(trabajo);
        result.setIdTipoEjecucionCalculo(trabajo.getIdProgramacion() != null ?
            TipoEjecucionCalculoEnum.PROGRAMADO.getId() :
            TipoEjecucionCalculoEnum.MANUAL.getId());
        TipoAmbitoEnum ambito = TipoAmbitoEnum.fromId(trabajo.getTipoAmbito().getId());
        //TODO [JESTEVEZ] Retirar esto cuando tengamos el origen múltiple
        if (CollectionUtils.isNotEmpty(trabajo.getOrigen())) {
            result.setIdOrigen(trabajo.getOrigen().get(0).getCclIdOrigen());
        }
        if (ambito != null) {
            result.setIdAmbito(ambito.getIcmIdAmbitoEjec());
            switch (ambito) {
                    //TODO [JESTEVEZ] Activar esto cuando tengamos el origen múltiple
//                case ORIGEN :
//                    result.setItem(
//                        trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenDtoToSaveProcesoParametersDto(trabajo.getOrigen()));
//                    break;
                case EMPRESA:
                    result.setItem(
                        trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaDtoToSaveProcesoParametersDto(trabajo.getEmpresa()));
                    break;
                case LOCALIZACION:
                    result.setItem(
                        trabajoAmbitoLocalizacionMapper.trabajoAmbitoLocalizacionDtoToSaveProcesoParametersDto(trabajo.getLocalizacion()));
                    break;
                case PERSONA:
                    result.setItem(
                        trabajoAmbitoPersonaMapper.trabajoAmbitoPersonaDtoToSaveProcesoParametersDto(trabajo.getPersona()));
                    break;
                default:
                    result.setItem(new ArrayList<>());
            }
        }
        return result;
    }

}
