package com.trame.recipe_book.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "meal_seasons")
public class MealSeasonEntity {

    @EmbeddedId
    private MealSeasonPK id = new MealSeasonPK();

    @ManyToOne
    @MapsId("meal_id")
    @JoinColumn(name = "meal_id")
    private MealEntity meal;

    @ManyToOne
    @MapsId("season_id")
    @JoinColumn(name = "season_id")
    private SeasonEntity season;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_source")
    private String createSource;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_source")
    private String updateSource;

    public MealSeasonEntity(MealEntity meal, SeasonEntity season) {
        this.meal = meal;
        this.season = season;
        LocalDateTime now = LocalDateTime.now();
        String createSource = "system";
        String updateSource = "system";

        this.createDate = now;
        this.createSource = createSource;
        this.updateDate = now;
        this.updateSource = updateSource;
    }
}

