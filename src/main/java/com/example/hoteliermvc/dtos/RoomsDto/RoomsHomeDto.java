package com.example.hoteliermvc.dtos.RoomsDto;

import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import lombok.Data;

import java.time.LocalDate;
@Data
public class RoomsHomeDto {
    private long id;
    private String product;
    private Integer numroom ;
    private Double price;
    private String photo;
    private CategoryHomeDto category;

}
