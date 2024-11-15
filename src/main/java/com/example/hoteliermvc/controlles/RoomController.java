package com.example.hoteliermvc.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {
    @GetMapping("/rooms")
    public String rooms() {
        return "/rooms";
    }
}
