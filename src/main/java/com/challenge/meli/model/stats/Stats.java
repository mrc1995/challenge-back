package com.challenge.meli.model.stats;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Stats {
    private int count_mutant_dna;
    private int count_human_dna;
    private Double ratio;
}
