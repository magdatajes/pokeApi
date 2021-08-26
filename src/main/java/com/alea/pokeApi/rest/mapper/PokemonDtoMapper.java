package com.alea.pokeApi.rest.mapper;

import com.alea.pokeApi.model.Pokemon;
import com.alea.pokeApi.rest.PokemonDto;

public class PokemonDtoMapper {

    public static PokemonDto mapPokemonDtofromEntity(final Pokemon pokemon) {
        return PokemonDto.builder().id(pokemon.getId()).weight(pokemon.getWeight())
                .height(pokemon.getHeight()).baseExperience(pokemon.getBaseExperience())
                .name(pokemon.getName()).build();
    }

    public static Pokemon mapPokemonFromDto(final PokemonDto pokemonDto) {
        return Pokemon.builder().id(pokemonDto.getId()).name(pokemonDto.getName())
                .height(pokemonDto.getHeight()).weight(pokemonDto.getWeight())
                .baseExperience(pokemonDto.getBaseExperience()).build();
    }

}
