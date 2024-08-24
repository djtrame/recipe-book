package com.trame.recipe_book.services.impl;

import com.trame.recipe_book.entities.SeasonEntity;
import com.trame.recipe_book.repositories.SeasonRepository;
import com.trame.recipe_book.services.SeasonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeasonServiceImpl implements SeasonService {

    private SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public SeasonEntity save(SeasonEntity seasonEntity) {
        return seasonRepository.save(seasonEntity);
    }

    @Override
    public Optional<SeasonEntity> findOne(Integer season_id) {
        return seasonRepository.findById(season_id);
    }

    @Override
    public List<SeasonEntity> findAll() {
        return StreamSupport.stream(seasonRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

}
