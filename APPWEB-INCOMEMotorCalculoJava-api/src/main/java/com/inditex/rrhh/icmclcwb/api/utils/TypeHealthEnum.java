package com.inditex.rrhh.icmclcwb.api.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeHealthEnum {

  AMIGA_HEALTH_STATUS_UP(1), VALIDATE_RESPONSE_STATUS_CODE_OK(2);

  private final Integer id;

  public static TypeHealthEnum getById(Integer id) {
    for (TypeHealthEnum e : values()) {
      if (e.id.equals(id)) {
        return e;
      }
    }
    return null;
  }

}
