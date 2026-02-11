package com.izamim.typeBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izamim.typeBot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
