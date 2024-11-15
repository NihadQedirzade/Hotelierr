package com.example.hoteliermvc.services;

import com.example.hoteliermvc.dtos.CategoryDto.CategoryCreateDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryUpdateDto;
import com.example.hoteliermvc.models.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryCreateDto categoryCreateDto);
    void updateCategory(CategoryUpdateDto categoryUpdateDto, Long id);
    void deleteCategory(Long id);
    List<CategoryHomeDto> getCategories();
    CategoryUpdateDto findCategoryById(long id);
    Category findById(Long id);
    List<CategoryDto> getAllCategories();


}
