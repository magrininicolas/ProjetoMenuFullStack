package com.nicolas.menu.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.nicolas.menu.models.FoodModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodResponseDTO(@NotBlank UUID id, @NotBlank String title, @NotBlank String image, @NotNull BigDecimal price) {
  public FoodResponseDTO(FoodModel food){
    this(food.getIdFood(), food.getTitle(), food.getImage(), food.getPrice());
  }
}
