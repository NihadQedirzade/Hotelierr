package com.example.hoteliermvc.controlles;

import com.example.hoteliermvc.dtos.RoomsDto.RoomsHomeDto;
import com.example.hoteliermvc.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
@Autowired
private RoomsService roomsService;

    @GetMapping("/")
    public String home(Model model) {
        List<RoomsHomeDto> rooms = roomsService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "/home";
    }
}
