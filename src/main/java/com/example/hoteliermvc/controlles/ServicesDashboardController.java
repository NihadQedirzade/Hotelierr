package com.example.hoteliermvc.controlles;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesCreateDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesDashboardDto;
import com.example.hoteliermvc.dtos.ServicesDto.ServicesUpdateDto;
import com.example.hoteliermvc.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ServicesDashboardController {
    @Autowired
    private ServicesService servicesService;

    private final Cloudinary cloudinary;

    public ServicesDashboardController(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @GetMapping("/dashboard/services")
    public String servicesIndex(Model model) {
        List<ServicesDashboardDto> data = servicesService.getServices();
        model.addAttribute("servicess", data);
        return "/dashboard/services/index";
    }

    @GetMapping("/dashboard/services/create")
    public String createServices() {
        return "/dashboard/services/create";
    }

    @PostMapping("/dashboard/services/create")
    public String create(ServicesCreateDto servicesCreateDto, @RequestParam("image") MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        servicesCreateDto.setIcon((String) uploadResult.get("url"));
        servicesService.addService(servicesCreateDto);
        return "redirect:/dashboard/services";
    }

    @GetMapping("/dashboard/services/delete/{id}")
    public String deleteServices(@PathVariable Long id) {
        return "/dashboard/services/delete";
    }

    @PostMapping("/dashboard/services/delete/{id}")
    public String removeServices(@PathVariable Long id) {
        servicesService.deleteService(id);
        return "redirect:/dashboard/services";
    }


    @GetMapping("/dashboard/services/update/{id}")
    public String updateServices(@PathVariable Long id, Model model) {
        ServicesUpdateDto servicesUpdateDto = servicesService.findUpdateServices(id);
        model.addAttribute("services", servicesUpdateDto);
        return "/dashboard/services/update";
    }

    @PostMapping("/dashboard/services/update/{id}")
    public String updateServices(@PathVariable Long id, ServicesUpdateDto servicesUpdateDto, @RequestParam("image") MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String uploadedImageUrl = (String) uploadResult.get("url");
        servicesUpdateDto.setIcon(uploadedImageUrl);
        servicesService.updateService(servicesUpdateDto, id);

        return "redirect:/dashboard/services";
    }

}

