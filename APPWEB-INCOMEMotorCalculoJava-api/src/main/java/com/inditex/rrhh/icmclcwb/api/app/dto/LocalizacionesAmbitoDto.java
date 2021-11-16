package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class LocalizacionesAmbitoDto {

  private List<Integer> localizaciones = null;

  @NonNull
  private Long idAmbito;

  public void setLocalizaciones(List<IdLocalizacionLocalDto> ids) {
    if (ids != null) {
      localizaciones = ids.stream()
          .map(IdLocalizacionLocalDto::getId)
          .map(Integer::valueOf)
          .collect(Collectors.toList());
    }
  }

  public boolean obtenerLocalizaciones() {
    return TipoAmbitoEnum.PERSONA.getId().equals(idAmbito)
        || TipoAmbitoEnum.LOCALIZACION.getId().equals(idAmbito);
  }

  public boolean hasData() {
    return !obtenerLocalizaciones() || !CollectionUtils.isEmpty(localizaciones);
  }

}
