package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTrabajo;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public abstract class TrabajoMapperDecorator extends TrabajoMapper {

    @Autowired
    private TrabajoMapper delegate;

    @Autowired
    private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

    @Autowired
    private TrabajoAmbitoLocalizacionMapper trabajoAmbitoLocalizacionMapper;

    @Autowired
    private TrabajoAmbitoPersonaMapper trabajoAmbitoPersonaMapper;

    @Override
    public Trabajo trabajoDtoToTrabajo(TrabajoDto src) {
        Trabajo result = delegate.trabajoDtoToTrabajo(src);
        result.setEstado(new EstadoTrabajo());
        result.getEstado().setId(src.getEstado().getId());
        return result;
    }

    @Override
    public SaveProcesoDto trabajoDtoToSaveProcesoDto(TrabajoDto trabajo) {
        SaveProcesoDto result = delegate.trabajoDtoToSaveProcesoDto(trabajo);
        TipoAmbitoEnum ambito = TipoAmbitoEnum.fromId(trabajo.getTipoAmbito().getId());
        if (ambito != null) {
            result.setIdAmbito(ambito.getIcmIdAmbitoEjec());
            switch (ambito) {
            case EMPRESA:
                result.setItem(trabajoAmbitoEmpresaMapper
                        .trabajoAmbitoEmpresaDtoToSaveProcesoParametersDto(trabajo.getEmpresa()));
                break;
            case LOCALIZACION:
                result.setItem(trabajoAmbitoLocalizacionMapper
                        .trabajoAmbitoLocalizacionDtoToSaveProcesoParametersDto(trabajo.getLocalizacion()));
                break;
            case PERSONA:
                result.setItem(trabajoAmbitoPersonaMapper
                        .trabajoAmbitoPersonaDtoToSaveProcesoParametersDto(trabajo.getPersona()));
                break;
            case SOCIEDAD:
                result.setIdOrganization(trabajo.getIdOrganization());
                result.setItem(new ArrayList<>());
                break;
            default:
                result.setItem(new ArrayList<>());
            }
        }
        return result;
    }

}
