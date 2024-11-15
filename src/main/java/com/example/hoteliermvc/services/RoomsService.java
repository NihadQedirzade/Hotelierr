package com.example.hoteliermvc.services;

import com.example.hoteliermvc.dtos.RoomsDto.RoomsCreateDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsDashboardDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsHomeDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsUpdateDto;
import com.example.hoteliermvc.models.Rooms;

import java.util.List;

public interface RoomsService {
    void addRoom(RoomsCreateDto RoomsCreateDto);
    void updateRoom(RoomsUpdateDto RoomsUpdateDto,Long id);
    void deleteRoom(Long id);
    List<RoomsHomeDto> getAllRooms();
    List<RoomsDashboardDto> getRooms();
    RoomsUpdateDto findUpdateRooms(Long id);
}
