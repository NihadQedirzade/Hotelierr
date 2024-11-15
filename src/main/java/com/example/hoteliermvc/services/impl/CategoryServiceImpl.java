package com.example.hoteliermvc.services.impl;


import com.example.hoteliermvc.dtos.CategoryDto.CategoryCreateDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import com.example.hoteliermvc.dtos.CategoryDto.CategoryUpdateDto;
import com.example.hoteliermvc.models.Category;
import com.example.hoteliermvc.repositories.CategoryRepository;
import com.example.hoteliermvc.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class CategoryServiceImpl implements CategoryService {

        private final CategoryRepository categoryRepository;
        private final ModelMapper modelMapper;

        public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
            this.categoryRepository = categoryRepository;
            this.modelMapper = modelMapper;
        }


        @Override
        public void addCategory(CategoryCreateDto categoryCreateDto) {
            Category category = new Category();
            category.setName(categoryCreateDto.getName());
            categoryRepository.save(category);
        }

        @Override
        public void updateCategory(CategoryUpdateDto categoryUpdateDto, Long id) {
            Category findCategory = categoryRepository.findById(id).orElseThrow();
            findCategory.setName(categoryUpdateDto.getName());
            categoryRepository.save(findCategory);
        }

        @Override
        public void deleteCategory(Long id) {
            categoryRepository.deleteById(id);
        }

        @Override
        public List<CategoryHomeDto> getCategories() {
            List<CategoryHomeDto> categories = categoryRepository.findAll()
                    .stream()
                    .map(category -> modelMapper.map(category, CategoryHomeDto.class))
                    .toList();
            return categories;
        }

        @Override
        public CategoryUpdateDto findCategoryById(long id) {
            Category findCategory = categoryRepository.findById(id).orElseThrow();
            CategoryUpdateDto result = modelMapper.map(findCategory, CategoryUpdateDto.class);
            return result;
        }

        @Override
        public Category findById(Long id) {
            return categoryRepository.findById(id).orElseThrow();
        }

        @Override
        public List<CategoryDto> getAllCategories() {
            List<Category> categories = categoryRepository.findAll();
            List<CategoryDto> result = categories
                    .stream()
                    .map(category -> modelMapper.map(category, CategoryDto.class))
                    .toList();
            return result;
        }
    }