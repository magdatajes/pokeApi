package com.alea.pokeApi.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class GenericObject implements Serializable {
    private static final long serialVersionUID = 4470635451563718004L;
    private String name;
    private String url;
}
