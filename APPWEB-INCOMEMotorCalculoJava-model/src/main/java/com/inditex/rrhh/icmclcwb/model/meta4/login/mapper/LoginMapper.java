package com.inditex.rrhh.icmclcwb.model.meta4.login.mapper;

import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.login.login.dto.LoginResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.Login;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4LoginOutput;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LoginMapper {

  @Mapping(source = "aiSUser", target = "username")
  @Mapping(source = "aiSPassword", target = "password")
  @Mapping(source = "aiSLanguage", target = "language")
  LoginRequestDto loginToLoginRequestDto(Login src);

  @Mapping(source = "username", target = "aiSUser")
  @Mapping(source = "password", target = "aiSPassword")
  @Mapping(source = "language", target = "aiSLanguage")
  Login loginRequestDtoToLogin(LoginRequestDto src);

  LoginResponseDto m4LoginOutputToLoginResponseDto(M4LoginOutput src);

  M4LoginOutput loginResponseDtoToM4LoginOutput(LoginResponseDto src);

}
