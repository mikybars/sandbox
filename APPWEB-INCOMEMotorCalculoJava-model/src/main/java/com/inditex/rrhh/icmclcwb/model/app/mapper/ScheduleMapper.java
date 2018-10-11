package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Schedule;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface ScheduleMapper {

    ScheduleDto scheduleToScheduleDto(Schedule src);

    Schedule scheduleDtoToSchedule(ScheduleDto src);

    List<ScheduleDto> scheduleToScheduleDto(List<Schedule> src);
}
