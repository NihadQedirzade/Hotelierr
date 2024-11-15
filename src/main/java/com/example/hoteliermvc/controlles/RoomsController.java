package com.example.hoteliermvc.controlles;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsCreateDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsDashboardDto;
import com.example.hoteliermvc.dtos.RoomsDto.RoomsUpdateDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesUpdateDto;
import com.example.hoteliermvc.services.CategoryService;
import com.example.hoteliermvc.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class RoomsController {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
    @Autowired
    private RoomsService roomsService;
    @Autowired
    private CategoryService categoryService;

    private final Cloudinary cloudinary;

    public RoomsController(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @GetMapping("/dashboard/rooms")
    public String roomsIndex(Model model) {
        List<RoomsDashboardDto> data = roomsService.getRooms();
        model.addAttribute("roomss", data);
        return "/dashboard/rooms/index";
    }

    @GetMapping("/dashboard/rooms/create")
    public String createRooms(Model model) {
        List<CategoryHomeDto> data = categoryService.getCategories();
        model.addAttribute("categories", data);
        return "/dashboard/rooms/create";
    }


    @PostMapping("/dashboard/rooms/create")
    public String create(RoomsCreateDto roomsCreateDto, @RequestParam("image") MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        roomsCreateDto.setPhoto((String) uploadResult.get("url"));
        roomsService.addRoom(roomsCreateDto);
        return "redirect:/dashboard/rooms";
    }

    @GetMapping("/dashboard/rooms/delete/{id}")
    public String deleteRooms(@PathVariable Long id) {
        return "/dashboard/rooms/delete";
    }

    @PostMapping("/dashboard/rooms/delete/{id}")
    public String removeRooms(@PathVariable Long id) {
        roomsService.deleteRoom(id);
        return "redirect:/dashboard/rooms";
    }


    @GetMapping("/dashboard/rooms/update/{id}")
    public String updateRooms(@PathVariable Long id, Model model) {
        RoomsUpdateDto room = roomsService.findUpdateRooms(id);
        List<CategoryHomeDto> categories = categoryService.getCategories();
        model.addAttribute("rooms", room);
        model.addAttribute("categories", categories);
        return "/dashboard/rooms/update";
    }
        @PostMapping("/dashboard/rooms/update/{id}")
        public String updateRooms(@PathVariable Long id, RoomsUpdateDto roomsUpdateDto, @RequestParam("image") MultipartFile file) throws IOException {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String uploadedImageUrl = (String) uploadResult.get("url");
            roomsUpdateDto.setPhoto(uploadedImageUrl);
            roomsService.updateRoom(roomsUpdateDto, id);

            return "redirect:/dashboard/rooms";
    }
}
