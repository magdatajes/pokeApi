package com.alea.pokeApi.service.impl;

import com.alea.pokeApi.jpa.PokemonJpa;
import com.alea.pokeApi.model.Pokemon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceTest {

    private static final Page<Pokemon> EMPTY_POKEMON_PAGE = Page.empty();
    private static final String POKEMON_NAME = "ditto";

    @Mock
    private PokemonJpa pokemonJpa;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    @Test
    public void findAllPokemonOrderedTestEmptyPage() {
        Mockito.when(pokemonJpa.findAll(Mockito.any(Pageable.class))).thenReturn(EMPTY_POKEMON_PAGE);
        assertThat(pokemonService.findAllPokemonOrdered(PageRequest.of(0, 5))).isEmpty();
    }

    @Test
    public void findAllPokemonOrderedTest() {
        final Pokemon pokemon = new Pokemon();
        pokemon.setName(POKEMON_NAME);
        final List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        final Page<Pokemon> pagedResponse = new PageImpl(pokemonList);
        Mockito.when(pokemonJpa.findAll(Mockito.any(Pageable.class))).thenReturn(pagedResponse);
        assertThat(pokemonService.findAllPokemonOrdered(PageRequest.of(0, 5))).isNotEmpty();
        assertThat(pokemonService.findAllPokemonOrdered(PageRequest.of(0, 5)).getContent().get(0).getName()).isEqualTo(POKEMON_NAME);
    }

}
