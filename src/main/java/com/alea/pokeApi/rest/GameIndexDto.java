package com.alea.pokeApi.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameIndexDto implements Serializable {

    private static final long serialVersionUID = -5498108719667655534L;
    @JsonProperty("version")
    private VersionDto version;
}
