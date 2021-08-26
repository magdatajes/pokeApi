package com.alea.pokeApi.config;

import com.alea.pokeApi.jpa.PokemonJpa;
import com.alea.pokeApi.model.Pokemon;
import com.alea.pokeApi.rest.GameIndexDto;
import com.alea.pokeApi.rest.PaginatedResponse;
import com.alea.pokeApi.rest.PokemonDto;
import com.alea.pokeApi.rest.ResultsDto;
import com.alea.pokeApi.rest.mapper.PokemonDtoMapper;
import com.alea.pokeApi.utils.Constants;
import com.alea.pokeApi.utils.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InitiationService {

    @Value(Constants.POKEMON_URL_PROPERTY)
    final String pokemonUrl = null;

    @Autowired
    private PokemonJpa pokemonJpa;

    @Autowired
    private RestTemplate restTemplate;

    public void populateDataBase() {
        final ResponseEntity<PaginatedResponse> response = restTemplate.getForEntity(pokemonUrl, PaginatedResponse.class);
        final Optional<PaginatedResponse> responseBodyOptional = Optional.ofNullable(response.getBody());
        if (responseBodyOptional.isEmpty()) {
            throw new RuntimeException();
        }
        final Integer totalPokemon = response.getBody().getCount();
        final String totalUrl = pokemonUrl + RestConstants.LIMIT_QUERY + totalPokemon;
        final ResponseEntity<PaginatedResponse> allPokemonsResponse = restTemplate.getForEntity(totalUrl, PaginatedResponse.class);
        final Optional<PaginatedResponse> bodyOptional = Optional.ofNullable(allPokemonsResponse.getBody());
        bodyOptional.ifPresent(paginatedResponse -> pokemonJpa.saveAll(getPokemon(paginatedResponse.getResults())));
    }

    private List<Pokemon> getPokemon(final List<ResultsDto> pokemonList) {
        final List<Pokemon> pokemonsToSave = new ArrayList<>();
        pokemonList.forEach(pokemonGenericObject -> {
            final ResponseEntity<PokemonDto> retrievedPokemon =
                    restTemplate.getForEntity(pokemonGenericObject.getUrl(), PokemonDto.class);
            final PokemonDto pokemonDto = retrievedPokemon.getBody();
            final List<GameIndexDto> versions = pokemonDto.getGameIndicesDto();
            final Optional<GameIndexDto> foundVersion = versions.stream()
                    .filter(version -> Constants.RED_VERSION.equals(version.getVersion().getName())).findFirst();
            if (foundVersion.isPresent()) {
                pokemonsToSave.add(PokemonDtoMapper.mapPokemonFromDto(pokemonDto));
            }
        });
        return pokemonsToSave;
    }
}
