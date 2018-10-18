package com.inditex.rrhh.icmclcwb.model.meta4.login.mapper;

import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.dto.LoginResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.Login;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4LoginOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface LoginMapper {

	@Mappings({ @Mapping(source = "in0", target = "username"), @Mapping(source = "in1", target = "password"),
					@Mapping(source = "in2", target = "language") })
	LoginRequestDto loginToLoginRequestDto(Login src);

	@Mappings({ @Mapping(source = "username", target = "in0"), @Mapping(source = "password", target = "in1"),
					@Mapping(source = "language", target = "in2") })
	Login loginRequestDtoToLogin(LoginRequestDto src);
	
	LoginResponseDto m4LoginOutputToLoginResponseDto(M4LoginOutput src);

	M4LoginOutput loginResponseDtoToM4LoginOutput(LoginResponseDto src);

}