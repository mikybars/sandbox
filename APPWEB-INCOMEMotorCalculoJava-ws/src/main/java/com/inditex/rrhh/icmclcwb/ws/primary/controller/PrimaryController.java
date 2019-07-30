package com.inditex.rrhh.icmclcwb.ws.primary.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/primary")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PrimaryController {

    @Autowired
    private PrimaryService primaryService;

    @GetMapping("/load/dml")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("Carga el script DML")
    public @Valid Boolean loadDML() {
        return primaryService.loadDML();
    }

}