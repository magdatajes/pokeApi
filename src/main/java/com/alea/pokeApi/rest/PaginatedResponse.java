package com.alea.pokeApi.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponse implements Serializable {
    private static final long serialVersionUID = 3377282817500738152L;
    private Integer count;
    private String next;
    private String previous;
    private List<ResultsDto> results;
}
