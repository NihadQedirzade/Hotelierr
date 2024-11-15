package com.example.hoteliermvc.services.impl;

import com.example.hoteliermvc.dtos.RoomsDto.RoomsDashboardDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsHomeDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsUpdateDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesCreateDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesDashboardDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesHomeDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesUpdateDto;
import com.example.hoteliermvc.models.Rooms;
import com.example.hoteliermvc.models.Services;
import com.example.hoteliermvc.repositories.RoomsRepository;
import com.example.hoteliermvc.repositories.ServicesRepository;
import com.example.hoteliermvc.services.ServicesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository serviceRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addService(ServicesCreateDto servicesCreateDto) {

        Services service = new Services();
        service.setServiceName(servicesCreateDto.getServiceName());
        service.setText(servicesCreateDto.getText());
        service.setIcon(servicesCreateDto.getIcon());
        serviceRepository.save(service);
    }

    @Override
    public void updateService(ServicesUpdateDto servicesUpdateDto, Long id) {
Services findService = serviceRepository.findById(id).orElseThrow();
findService.setServiceName(servicesUpdateDto.getServiceName());
findService.setText(servicesUpdateDto.getText());
findService.setIcon(servicesUpdateDto.getIcon());
serviceRepository.save(findService);
    }

    @Override
    public void deleteService(Long id) {
Services findService = serviceRepository.findById(id).orElseThrow();
serviceRepository.delete(findService);
    }

    @Override
    public List<ServicesHomeDto> getAllServices() {
        List<ServicesHomeDto> services = serviceRepository.findAll()
                .stream()
                .map(services1 -> modelMapper.map(services1, ServicesHomeDto.class))
                .toList();
        return services;
    }

    @Override
    public List<ServicesDashboardDto> getServices() {
        List<ServicesDashboardDto> room12 = serviceRepository.findAll()
                .stream()
                .map(a-> modelMapper.map(a, ServicesDashboardDto.class))
                .toList();
        return room12;
    }

    @Override
    public ServicesUpdateDto findUpdateServices(Long id) {
        Services findServices = serviceRepository.findById(id).orElseThrow();
        ServicesUpdateDto result = modelMapper.map(findServices, ServicesUpdateDto.class);
        return result;
    }
}
