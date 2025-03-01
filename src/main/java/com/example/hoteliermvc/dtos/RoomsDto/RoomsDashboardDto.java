package com.example.hoteliermvc.dtos.RoomsDto;

import com.example.hoteliermvc.dtos.CategoryDto.CategoryHomeDto;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RoomsDashboardDto {

    private long id;
    private String aboutRoom;
    private Integer numroom ;
    private Double price;
    private String photo;
    private CategoryHomeDto category;
}
