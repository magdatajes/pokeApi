package com.alea.pokeApi.controller;

import com.alea.pokeApi.rest.PokemonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PokemonApi {

    Page<PokemonDto> getPokemonOrdered(Pageable pageable);
}
