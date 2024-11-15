package com.example.hoteliermvc.services;

import com.example.hoteliermvc.dtos.RoomsDto.RoomsUpdateDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesCreateDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesDashboardDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesHomeDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesUpdateDto;

import java.util.List;

public interface ServicesService {
    void addService(ServicesCreateDto ServicesCreateDto);
    void updateService(ServicesUpdateDto ServicesUpdateDto, Long id);
    void deleteService(Long id);
    List<ServicesHomeDto> getAllServices();
    List<ServicesDashboardDto> getServices();
    ServicesUpdateDto findUpdateServices(Long id);
}
