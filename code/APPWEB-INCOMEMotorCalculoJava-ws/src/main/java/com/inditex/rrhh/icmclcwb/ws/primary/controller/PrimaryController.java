package com.inditex.rrhh.icmclcwb.ws.primary.controller;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;
import com.inditex.rrhh.icmclcwb.service.PrimaryApi;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimaryController implements PrimaryApi {

  @Autowired
  private PrimaryService primaryService;

  @Override
  public @Valid ResponseEntity<Boolean> loadDML(@PathVariable final String path) {
    return new ResponseEntity<>(this.primaryService.loadDML(path), HttpStatus.OK);
  }

  @Override
  public @NotNull ResponseEntity<Object> changelogDML() {
    return new ResponseEntity<>(this.primaryService.changelogDML(), HttpStatus.OK);
  }

  @Override
  public @NotNull ResponseEntity<Object> changelogDDL() {
    return new ResponseEntity<>(this.primaryService.changelogDDL(), HttpStatus.OK);
  }

}
