package com.alea.pokeApi.controller.impl;

import com.alea.pokeApi.controller.PokemonApi;
import com.alea.pokeApi.rest.PokemonDto;
import com.alea.pokeApi.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonApiImpl implements PokemonApi {

    private final PokemonService pokemonService;

    @Override
    @GetMapping
    public Page<PokemonDto> getPokemonOrdered(final Pageable pageable) {
        return pokemonService.findAllPokemonOrdered(pageable);
    }
}
