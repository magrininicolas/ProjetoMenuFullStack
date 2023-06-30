package com.nicolas.menu.dto;

import java.math.BigDecimal;

import com.nicolas.menu.models.FoodModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodRequestDTO(@NotBlank String title, @NotBlank String image, @NotNull BigDecimal price) {
  public FoodRequestDTO(FoodModel food){
    this(food.getTitle(), food.getImage(), food.getPrice());
  }
}
