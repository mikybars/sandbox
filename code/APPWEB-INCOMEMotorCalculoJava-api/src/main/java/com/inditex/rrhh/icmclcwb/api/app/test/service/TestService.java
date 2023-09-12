package com.inditex.rrhh.icmclcwb.api.app.test.service;

import com.inditex.rrhh.icmclcwb.dto.AjusteComisionDTO;
import com.inditex.rrhh.icmclcwb.dto.RelojDTO;
import com.inditex.rrhh.icmclcwb.dto.SsoDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface TestService {

  RelojDTO reloj();

  SsoDTO sso();

  void errorSync();

  void errorAsync();

  void sesion();

  void programacionBatch();

  void testBloqueos(@NotNull final Long limit);

  void trabajoFase1a();

  String sqlFormatter(@NotBlank String sql);

  Boolean testUrl(@NotBlank String sql);

  void sendMail();

  void comisTest();

  void ptrTestService();

  void ptrTestBbddSync();

  void ptrTestBbddAsync();

  void slrhorcomsTest();

  // Comienzo de normalización de tareas consolidadas (para borrar)

  AjusteComisionDTO normalizarAjusteComision(@Positive @NotNull final Integer limit);

  // Fin de normalización de tareas consolidadas (para borrar)

}
