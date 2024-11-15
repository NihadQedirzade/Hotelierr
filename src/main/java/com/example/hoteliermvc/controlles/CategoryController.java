package com.example.hoteliermvc.controlles;

import com.example.hoteliermvc.dtos.CategoryDto.CategoryCreateDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryUpdateDto;
import com.example.hoteliermvc.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class CategoryController {

        private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

        @GetMapping("/dashboard/category")
        public String dashboardCategory(Model model) {
        List<CategoryHomeDto> data = categoryService.getCategories();
        model.addAttribute("categories", data);
        return "/dashboard/category/index";
    }
        @GetMapping("/dashboard/category/create")
        public String createCategory() {
        return "/dashboard/category/create";
    }

        @PostMapping("/dashboard/category/create")
        public String createCategory(CategoryCreateDto categoryCreateDto) {
        categoryService.addCategory(categoryCreateDto);
        return "redirect:/dashboard/category";
    }

        @GetMapping("/dashboard/category/update/{id}")
        public String updateCategory(@PathVariable Long id, Model model) {
        CategoryUpdateDto data = categoryService.findCategoryById(id);
        model.addAttribute("categories", data);
        return "/dashboard/category/update";
    }

        @PostMapping("/dashboard/category/update/{id}")
        public String updateCategory(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto) {
        categoryService.updateCategory(categoryUpdateDto,id);
        return "redirect:/dashboard/category";
    }


        @GetMapping("/dashboard/category/delete/{id}")
        public String deleteCategory(@PathVariable Long id) {

        return "/dashboard/category/delete";
    }

        @PostMapping("/dashboard/category/delete/{id}")
        public String removeCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);

        return "redirect:/dashboard/category";
    }

    }