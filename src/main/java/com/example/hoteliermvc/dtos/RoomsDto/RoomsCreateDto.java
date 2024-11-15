package com.example.hoteliermvc.dtos.RoomsDto;

import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
public class RoomsCreateDto {
    private String product;
    private Integer numroom ;
    private Double price;
    private String photo;
    private Long categoryId;
}
