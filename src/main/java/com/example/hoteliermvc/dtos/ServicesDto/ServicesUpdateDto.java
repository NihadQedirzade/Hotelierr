package com.example.hoteliermvc.dtos.ServicesDto;

import lombok.Data;

@Data
public class ServicesUpdateDto {
    private Long id;
    private String serviceName;
    private String text;
    private String icon;
}
