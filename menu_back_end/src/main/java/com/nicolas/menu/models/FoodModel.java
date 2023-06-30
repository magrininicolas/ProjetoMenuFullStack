package com.nicolas.menu.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "foods")
@Table(name = "TB_FOOD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idFood")
public class FoodModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idFood;

  private String title;

  private String image;

  private BigDecimal price;
}
