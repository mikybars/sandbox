package com.inditex.rrhh.icmclcwb.ws.controller.app;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleJobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ScheduleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/schedule")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

    @PostMapping
    @ApiOperation("Inserta una nueva programación")
    public @Valid ScheduleDto insert(@Valid @RequestBody final ScheduleDto schedule) {
        return scheduleService.createSchedule(schedule);
    }
	
	@GetMapping(path = "/run/")
	@ApiOperation("Revisa si hay programaciones pendientes de lanzar y en caso afirmativo, genera el trabajo")
	@PreAuthorize("hasAuthority('admin')")
	public List<ScheduleJobDto> run() {
		return scheduleService.run();
	}

}