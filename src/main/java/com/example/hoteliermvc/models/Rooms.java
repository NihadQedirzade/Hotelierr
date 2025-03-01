package com.example.hoteliermvc.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@Table(name = "rooms")

public class Rooms{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aboutRoom;
    private Integer numroom ;
    private Double price;
    private String photo;

    @ManyToOne
    private Category category;
}
