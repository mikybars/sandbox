package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.dto.AjusteComisionDTO;
import com.inditex.rrhh.icmclcwb.dto.RelojDTO;
import com.inditex.rrhh.icmclcwb.dto.SsoDTO;
import com.inditex.rrhh.icmclcwb.service.TestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestApi {

  @Autowired
  private TestService testService;

  @Override
  public ResponseEntity<RelojDTO> reloj() {
    return new ResponseEntity<>(this.testService.reloj(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<SsoDTO> sso() {
    return new ResponseEntity<>(this.testService.sso(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> errorSync() {
    this.testService.errorSync();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> errorAsync() {
    this.testService.errorAsync();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> sesion() {
    this.testService.sesion();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> programacionBatch() {
    this.testService.programacionBatch();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> testConcurrencia(@PathVariable final Long limit) {
    this.testService.testBloqueos(limit);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Boolean> testUrl(@RequestBody final String url) {
    return new ResponseEntity<>(this.testService.testUrl(url), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> trabajoFase1a() {
    this.testService.trabajoFase1a();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> sqlFormatter(@RequestBody final String sql) {
    return new ResponseEntity<>(this.testService.sqlFormatter(sql), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> sendMail() {
    this.testService.sendMail();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> comisTest() {
    this.testService.comisTest();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> ptrTest() {
    this.testService.ptrTestService();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> iopcomercialcalendarTest() {
    this.testService.iopcomercialcalendarTest();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> ptrTestBbddSync() {
    this.testService.ptrTestBbddSync();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> ptrTestBbddAsync() {
    this.testService.ptrTestBbddAsync();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Override
  public ResponseEntity<AjusteComisionDTO> normalizarAjusteComision(@PathVariable final Integer limit) {
    return new ResponseEntity<>(this.testService.normalizarAjusteComision(limit), HttpStatus.OK);
  }

  // Fin de normalización de tareas consolidadas (para borrar)

}
