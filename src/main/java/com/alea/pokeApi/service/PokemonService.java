package com.alea.pokeApi.service;

import com.alea.pokeApi.rest.PokemonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PokemonService {
    Page<PokemonDto> findAllPokemonOrdered(Pageable pageable);
}
