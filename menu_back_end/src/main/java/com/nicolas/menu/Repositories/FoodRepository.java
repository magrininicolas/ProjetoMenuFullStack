package com.nicolas.menu.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.menu.models.FoodModel;

public interface FoodRepository extends JpaRepository<FoodModel, UUID> {
}
