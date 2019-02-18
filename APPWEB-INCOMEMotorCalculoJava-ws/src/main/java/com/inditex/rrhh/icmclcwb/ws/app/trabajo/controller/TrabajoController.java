package com.inditex.rrhh.icmclcwb.ws.app.trabajo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/trabajo")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class TrabajoController {

}
