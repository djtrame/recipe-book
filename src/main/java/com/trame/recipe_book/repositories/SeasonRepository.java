package com.trame.recipe_book.repositories;

import com.trame.recipe_book.entities.SeasonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<SeasonEntity, Integer> {


}
