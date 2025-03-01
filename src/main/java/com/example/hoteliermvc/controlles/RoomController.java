package com.example.hoteliermvc.controlles;

import com.example.hoteliermvc.services.RoomsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RoomController {
    private final RoomsService roomsService;
    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", roomsService.getAllRooms());
        return "/rooms";
    }
}
