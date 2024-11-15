package com.example.hoteliermvc.dtos.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Name is mandatory")
    private Long id;
}