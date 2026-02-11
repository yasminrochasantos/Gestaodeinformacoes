package com.izamim.typeBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izamim.typeBot.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
