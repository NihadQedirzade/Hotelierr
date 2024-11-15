package com.example.hoteliermvc.dtos.ServicesDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ServicesDashboardDto {
    private Long id;
    private String serviceName;
    private String text;
    private String icon;
}
