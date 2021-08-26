package com.alea.pokeApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pokemon")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon implements Serializable {

    private static final long serialVersionUID = -1940706850759819467L;
    @Id
    private Integer id;
    private Integer weight;
    private Integer height;
    private Integer baseExperience;
    private String name;
}
