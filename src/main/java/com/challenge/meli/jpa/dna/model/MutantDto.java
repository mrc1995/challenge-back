package com.challenge.meli.jpa.dna.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "mutants")
public class MutantDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mutant_dna")
    private Integer countMutant;
    @Column(name = "human_dna")
    private Integer countHuman;
}
