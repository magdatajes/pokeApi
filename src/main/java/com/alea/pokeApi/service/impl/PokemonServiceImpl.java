package com.alea.pokeApi.service.impl;

import com.alea.pokeApi.jpa.PokemonJpa;
import com.alea.pokeApi.model.Pokemon;
import com.alea.pokeApi.rest.PokemonDto;
import com.alea.pokeApi.rest.mapper.PokemonDtoMapper;
import com.alea.pokeApi.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokemonJpa pokemonJpa;

    @Override
    public Page<PokemonDto> findAllPokemonOrdered(final Pageable pageable) {
        final Page<Pokemon> pokemonPage = pokemonJpa.findAll(pageable);
        return pokemonPage.map(PokemonDtoMapper::mapPokemonDtofromEntity);
    }
}
