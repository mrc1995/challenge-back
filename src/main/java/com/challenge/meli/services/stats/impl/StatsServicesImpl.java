package com.challenge.meli.services.stats.impl;

import com.challenge.meli.jpa.dna.DnaRepository;
import com.challenge.meli.jpa.stats.StatsRepository;
import com.challenge.meli.model.stats.Stats;
import com.challenge.meli.services.stats.StatsServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatsServicesImpl implements StatsServices {

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private StatsRepository statsRepository;

    public Stats getStatsMutants(){
        return statsRepository.getStats();
    }
}
