package com.nicolas.menu.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nicolas.menu.Repositories.FoodRepository;
import com.nicolas.menu.dto.FoodRequestDTO;
import com.nicolas.menu.dto.FoodResponseDTO;
import com.nicolas.menu.models.FoodModel;

@Service
public class FoodService {

  @Autowired
  private FoodRepository foodRepository;

  public List<FoodResponseDTO> getAllFoods() {
    return foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
  }

  public Iterable<FoodResponseDTO> getFoodsByPage(Integer numberPages, Integer qtyFoods) {
    if(qtyFoods >= 5) {
      qtyFoods = 5;
    }
    PageRequest page = PageRequest.of(numberPages, qtyFoods);
    return foodRepository.findAll(page).stream().map(FoodResponseDTO::new).toList();
  }

  public void saveFood(FoodRequestDTO foodRequestDTO){
    FoodModel food = new FoodModel();
    BeanUtils.copyProperties(foodRequestDTO, food);
    foodRepository.save(food);
  }
}
