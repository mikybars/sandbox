package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
        //TODO [COMUN] Eliminar esta linea o arreglarla cuando se decida si se envía o no el estado de ejecución
        //1 = Pendiente, si se mantiene hay que usar el enumerado
        result.setIdEstadoEjecucion("1");

        TipoAmbitoEnum ambito = TipoAmbitoEnum.fromId(trabajo.getTipoAmbito().getId());
        if (ambito != null) {
            result.setIdAmbito(ambito.getIcmIdAmbitoEjec());
            switch (ambito) {
                case ORIGEN:
                    result.setItem(
                        trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenDtoToSaveProcesoParametersDto(trabajo.getOrigen()));
                    break;
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
            }
        }
        return result;
    }

}
