package com.example.hoteliermvc.dtos.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
public class CategoryHomeDto {
    @NotBlank(message = "Name is mandatory")
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
}