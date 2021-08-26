package com.alea.pokeApi.jpa;

import com.alea.pokeApi.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonJpa extends JpaRepository<Pokemon, Integer> {

    @Override
    Page<Pokemon> findAll(Pageable pageable);
}
