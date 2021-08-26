package com.alea.pokeApi.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonDto implements Serializable {

    private static final long serialVersionUID = 1399067172510605302L;
    private Integer id;
    private Integer weight;
    private Integer height;
    @JsonProperty("base_experience")
    private Integer baseExperience;
    private String name;
    @JsonProperty("game_indices")
    private List<GameIndexDto> gameIndicesDto;
}
