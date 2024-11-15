package com.example.hoteliermvc.repositories;

import com.example.hoteliermvc.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, Long> {
}
