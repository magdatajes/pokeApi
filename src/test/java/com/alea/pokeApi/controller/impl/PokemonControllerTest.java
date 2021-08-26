package com.alea.pokeApi.controller.impl;

import com.alea.pokeApi.rest.PokemonDto;
import com.alea.pokeApi.service.impl.PokemonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PokemonControllerTest {

    private static final String POKEMON_NAME = "ditto";

    @Mock
    private PokemonServiceImpl pokemonService;

    @InjectMocks
    private PokemonApiImpl pokemonController;

    @Test
    public void getAllPokemonsTest() {
        final PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName(POKEMON_NAME);
        final List<PokemonDto> pokemonList = new ArrayList<>();
        pokemonList.add(pokemonDto);
        final Page<PokemonDto> pagedResponse = new PageImpl(pokemonList);
        Mockito.when(pokemonService.findAllPokemonOrdered(PageRequest.of(0, 20))).thenReturn(pagedResponse);
        final Page<PokemonDto> response = pokemonController.getPokemonOrdered(PageRequest.of(0, 20));
        assertEquals(pagedResponse, response);
    }
}
