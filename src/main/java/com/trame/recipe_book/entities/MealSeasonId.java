package com.trame.recipe_book.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@AllArgsConstructor
//@NoArgsConstructor
//@Embeddable
public class MealSeasonId implements Serializable {
    @Column(name = "meal_id")
    private Integer meal_id;
    
    @Column(name = "season_id")
    private Integer season_id;
}
