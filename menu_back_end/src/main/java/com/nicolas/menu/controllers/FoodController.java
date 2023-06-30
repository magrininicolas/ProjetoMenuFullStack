package com.nicolas.menu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.menu.dto.FoodRequestDTO;
import com.nicolas.menu.dto.FoodResponseDTO;
import com.nicolas.menu.services.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

  @Autowired
  private FoodService foodService;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public ResponseEntity<List<FoodResponseDTO>> getAllFoods() {
    return ResponseEntity.status(HttpStatus.OK).body(foodService.getAllFoods());
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("/{numberPages}/{qtyFoods}")
  public ResponseEntity<Iterable<FoodResponseDTO>> getFoodsByPage(@PathVariable Integer numberPages, @PathVariable Integer qtyFoods){
    return ResponseEntity.status(HttpStatus.OK).body(foodService.getFoodsByPage(numberPages, qtyFoods));
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping
  public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO foodRequestDTO){
    foodService.saveFood(foodRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body("Food inserted successfully");
  }
}
