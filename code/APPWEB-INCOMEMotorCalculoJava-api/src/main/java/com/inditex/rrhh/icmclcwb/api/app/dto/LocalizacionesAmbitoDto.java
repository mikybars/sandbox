package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class LocalizacionesAmbitoDto {

  private List<Integer> localizaciones = null;

  @NotNull
  private Long idAmbito;

  public void setLocalizaciones(List<IdLocalizacionLocalDto> ids) {
    if (ids != null) {
      this.localizaciones = ids.stream()
          .map(IdLocalizacionLocalDto::getId)
          .map(Integer::valueOf)
          .collect(Collectors.toList());
    }
  }

  public boolean obtenerLocalizaciones() {
    return TipoAmbitoEnum.PERSONA.getId().equals(this.idAmbito)
        || TipoAmbitoEnum.LOCALIZACION.getId().equals(this.idAmbito);
  }

  public boolean hasData() {
    return !this.obtenerLocalizaciones() || !CollectionUtils.isEmpty(this.localizaciones);
  }

}
