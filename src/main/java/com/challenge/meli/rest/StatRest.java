package com.challenge.meli.rest;

import com.challenge.meli.model.stats.Stats;
import com.challenge.meli.services.stats.StatsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/stats", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StatRest {

    @Autowired
    private StatsServices statsServices;

    @GetMapping
    public Stats getStats(){
        return statsServices.getStatsMutants();
    }
}
