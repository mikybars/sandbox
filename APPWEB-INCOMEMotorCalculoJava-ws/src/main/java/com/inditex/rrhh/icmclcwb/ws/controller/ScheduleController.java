package com.inditex.rrhh.icmclcwb.ws.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.dto.ScheduleDTO;
import com.inditex.rrhh.icmclcwb.api.service.ScheduleService;
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

	@GetMapping
    @ApiOperation("Find all schedules")
    public List<ScheduleDTO> findAll() {
        List<ScheduleDTO> schedules = this.scheduleService.findSchedules(Collections.emptyList());
        return schedules;
    }

    @GetMapping(path = "/count/")
    @ApiOperation("Get the number of schedules")
    public Long count() {
        return this.scheduleService.countSchedules();
    }

    @GetMapping(path = "{id}")
    @ApiOperation("Find schedule by id")
    public ScheduleDTO finById(@PathVariable final Integer id) {
        return this.scheduleService.findSchedule(id);
    }

    @GetMapping(path = "/findByIdSecure/{id}")
    @ApiOperation("Find schedule by id from given rol. The user should have a rol TESTSECURITY")
    @PreAuthorize("hasAuthority('admin')")
    public ScheduleDTO findByIdSecure(@PathVariable final Integer id) {
        return this.scheduleService.findSchedule(id);
    }

    @PostMapping
    @ApiOperation("Insert a new schedule")
    public @Valid ScheduleDTO insert(@Valid @RequestBody final ScheduleDTO schedule) {
        final Integer id = this.scheduleService.createSchedule(schedule);
        schedule.setId(id);
        return schedule;
    }

    @PutMapping(path = "{id}")
    @ApiOperation("Modify an existing schedule")
    public ScheduleDTO modify(@PathVariable final Integer id, @RequestBody final ScheduleDTO schedule) {
        schedule.setId(id);
        if (this.scheduleService.modifySchedule(schedule)) {
            return finById(schedule.getId());
        }
        return schedule;
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation("Remove a schedule by id")
    public Integer delete(@PathVariable final Integer id) {
        this.scheduleService.deleteSchedule(id);
        return id;
    }

}