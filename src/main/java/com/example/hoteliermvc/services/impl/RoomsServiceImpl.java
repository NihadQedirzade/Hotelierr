package com.example.hoteliermvc.services.impl;

import com.example.hoteliermvc.dtos.RoomsDto.RoomsCreateDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsDashboardDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsHomeDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsUpdateDto;
import com.example.hoteliermvc.exception.NotFoundException;
import com.example.hoteliermvc.models.Category;
import com.example.hoteliermvc.models.Rooms;
import com.example.hoteliermvc.repositories.RoomsRepository;
import com.example.hoteliermvc.services.CategoryService;
import com.example.hoteliermvc.services.RoomsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void addRoom(RoomsCreateDto roomsCreateDto) {
        Category findCategory = categoryService.findById(roomsCreateDto.getCategoryId());
        Rooms rooms = new Rooms();

        rooms.setAboutRoom(roomsCreateDto.getAboutRoom());
        rooms.setPrice(roomsCreateDto.getPrice());
        rooms.setNumroom(roomsCreateDto.getNumroom());
        rooms.setPhoto(roomsCreateDto.getPhoto());
        rooms.setCategory(findCategory);
        roomsRepository.save(rooms);

    }

    @Override
    public void updateRoom(RoomsUpdateDto roomsUpdateDto, Long id) {
        Category findCategory = categoryService.findById(roomsUpdateDto.getCategoryId());
        Rooms findRooms = roomsRepository.findById(id).orElseThrow();
        findRooms.setAboutRoom(roomsUpdateDto.getAboutRoom());
        findRooms.setPrice(roomsUpdateDto.getPrice());
        findRooms.setNumroom(roomsUpdateDto.getNumroom());
        findRooms.setPhoto(roomsUpdateDto.getPhoto());
        findRooms.setCategory(findCategory);
       roomsRepository.save(findRooms);

    }

    @Override
    public void deleteRoom(Long id) {
            Rooms findRooms = roomsRepository.findById(id).orElseThrow();
        roomsRepository.delete(findRooms);

    }

    @Override
    public List<RoomsHomeDto> getAllRooms() {
        List<RoomsHomeDto> room = roomsRepository.findAll()
                .stream()
                .map(rooms1 -> modelMapper.map(rooms1, RoomsHomeDto.class))
                .toList();

        return room;
    }

    @Override
    public List<RoomsDashboardDto> getRooms(){
        List<RoomsDashboardDto> room12 = roomsRepository.findAll()
                .stream()
                .map(rooms1 -> modelMapper.map(rooms1, RoomsDashboardDto.class))
                .toList();
        return room12;
    }

    @Override
    public RoomsUpdateDto findUpdateRooms(Long id) {
        Rooms findRooms = roomsRepository.findById(id).orElseThrow();
        RoomsUpdateDto result = modelMapper.map(findRooms, RoomsUpdateDto.class);
        return result;
        }

    }
