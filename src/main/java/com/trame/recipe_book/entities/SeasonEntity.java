package com.trame.recipe_book.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "seasons")
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "season_id_seq")
    private Integer season_id;

    private String name;

    //attempting to implement a Many to Many relationship with an entity that joins Meals and Seasons, instead of using @ManyToMany


//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "SeasonIngredients",
//            joinColumns = @JoinColumn(name = "season_id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
//    )
//    private Set<IngredientEntity> seasonIngredients = new HashSet<>();
//
//    public void linkSeasonToIngredient(IngredientEntity ingredientEntity) {
//        seasonIngredients.add(ingredientEntity);
//    }
}
