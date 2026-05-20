package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTrabajo;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TrabajoMapperDecorator extends TrabajoMapper {

  @Autowired
  private TrabajoMapper delegate;

  @Autowired
  private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

  @Autowired
  private TrabajoAmbitoLocalizacionMapper trabajoAmbitoLocalizacionMapper;

  @Autowired
  private TrabajoAmbitoPersonaMapper trabajoAmbitoPersonaMapper;

  @Autowired
  private EntityManager entityManager;

  @Override
  public Trabajo trabajoDtoToTrabajo(final TrabajoDTO src) {
    final Trabajo result = this.delegate.trabajoDtoToTrabajo(src);
    result.setEstado(this.entityManager.getReference(EstadoTrabajo.class, src.getEstadoTrabajo().getId()));
    return result;
  }

  @Override
  public SaveProcesoDto trabajoDtoToSaveProcesoDto(final TrabajoDTO trabajo) {
    final SaveProcesoDto result = this.delegate.trabajoDtoToSaveProcesoDto(trabajo);
    final TipoAmbitoEnum ambito = TipoAmbitoEnum.fromId(trabajo.getTipoAmbito().getId());
    if (ambito != null) {
      result.setIdAmbito(ambito.getIcmIdAmbitoEjec());
      switch (ambito) {
        case EMPRESA:
          result.setItem(this.trabajoAmbitoEmpresaMapper
              .trabajoAmbitoEmpresaDtoToSaveProcesoParametersDto(trabajo.getEmpresa()));
          break;
        case LOCALIZACION:
          result.setItem(this.trabajoAmbitoLocalizacionMapper
              .trabajoAmbitoLocalizacionDtoToSaveProcesoParametersDto(trabajo.getLocalizacion()));
          break;
        case PERSONA:
          result.setItem(this.trabajoAmbitoPersonaMapper
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
