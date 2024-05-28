package com.inditex.rrhh.icmclcwb.ws.authorization;

public class AuthorizationKey {

  public static final String IS_USER = "hasAnyAuthority('ADMINISTRADOR_GLOBAL','ADMINISTRADOR_LOCAL')";

  public static final String IS_ADMIN = "hasAnyAuthority('ADMINISTRADOR_GLOBAL','ADMINISTRADOR_LOCAL')";

  private AuthorizationKey() {
  }

}
