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
@Table(name = "meals")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_id_seq")
    @SequenceGenerator(name = "meal_id_seq", allocationSize = 1) //default is 50, which makes your IDs go haywire each time you run the app
    private Integer meal_id;

    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "MealIngredients",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<IngredientEntity> mealIngredients = new HashSet<>();

    public void linkMealToIngredient(IngredientEntity ingredientEntity) {
        mealIngredients.add(ingredientEntity);
    }

    //8-26-24 - taking another shot at getting a custom junction table entity to work
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "MealSeasons",
//            joinColumns = @JoinColumn(name = "meal_id"),
//            inverseJoinColumns = @JoinColumn(name = "season_id")
//    )
//    private Set<SeasonEntity> mealSeasons = new HashSet<>();
//
//    public void linkMealToSeason(SeasonEntity seasonEntity) {
//        mealSeasons.add(seasonEntity);
//    }


    @OneToMany(mappedBy = "meal")
    private Set<MealSeasonEntity> mealSeasons = new HashSet<>();

//    public void linkMealToSeason(MealSeasonEntity mealSeasonEntity) {
//        mealSeasons.add(mealSeasonEntity);
//    }
}
