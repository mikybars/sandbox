package com.inditex.rrhh.icmclcwb.model.service;

import com.inditex.rrhh.icmclcwb.api.dto.ScheduleDTO;
import com.inditex.rrhh.icmclcwb.api.service.ScheduleService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;

import javax.validation.Valid;

@Service
@Validated
public class ScheduleServiceImpl implements ScheduleService {
    
    @Autowired
    private Logger LOG;

	@Override
	public Integer createSchedule(@Valid ScheduleDTO schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSchedule(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifySchedule(@Valid ScheduleDTO schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ScheduleDTO findSchedule(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> findSchedules(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countSchedules() {
		// TODO Auto-generated method stub
		return null;
	}
    
}