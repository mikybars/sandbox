package com.inditex.rrhh.icmclcwb.model.mapper;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.login.LoginDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.Login;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface LoginMapper {

	@Mappings({ @Mapping(source = "in0", target = "username"), @Mapping(source = "in1", target = "password"),
					@Mapping(source = "in2", target = "language") })
	LoginDTO asLoginDTO(Login src);

	@Mappings({ @Mapping(source = "username", target = "in0"), @Mapping(source = "password", target = "in1"),
					@Mapping(source = "language", target = "in2") })
	Login asLogin(LoginDTO src);

}