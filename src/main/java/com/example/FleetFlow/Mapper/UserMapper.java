package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.AuthenticationResponceDTO;
import com.example.FleetFlow.DTO.RegisterUserDTO;
import com.example.FleetFlow.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class UserMapper {
    User ToEntity(RegisterUserDTO registerUserDTO);
    AuthenticationResponceDTO ToDTO(User user);

}
