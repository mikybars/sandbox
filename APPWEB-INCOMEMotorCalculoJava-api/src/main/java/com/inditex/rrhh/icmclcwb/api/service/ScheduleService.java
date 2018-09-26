package com.inditex.rrhh.icmclcwb.api.service;

import com.inditex.rrhh.icmclcwb.api.dto.ScheduleDTO;

import javax.validation.Valid;
import java.util.List;

public interface ScheduleService {
    
    Integer createSchedule(@Valid final ScheduleDTO schedule);
    
    boolean deleteSchedule(final Integer id);
    
    boolean modifySchedule(@Valid final ScheduleDTO schedule);
    
    ScheduleDTO findSchedule(final Integer id);
    
    List<ScheduleDTO> findSchedules(final List<Integer> ids);
    
    Long countSchedules();
    
}