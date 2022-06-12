package com.challenge.meli.services.stats;

import com.challenge.meli.jpa.stats.StatsRepository;
import com.challenge.meli.model.stats.Stats;
import com.challenge.meli.services.mutant.MutantServices;
import com.challenge.meli.services.stats.impl.StatsServicesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = StatsServicesImpl.class)
public class StatsServicesTest {

    @Mock
    private ObjectMapper mapper;
    @Mock
    private StatsRepository statsRepository;
    @InjectMocks
    private StatsServicesImpl statsServices;

    @Test
    public void getStatsMutants() {
        Stats stats = new Stats();
        stats.setCount_human_dna(100);
        stats.setCount_mutant_dna(40);
        stats.setRatio(0.4);
        Mockito.when(statsRepository.getStats()).thenReturn(stats);
        statsServices.getStatsMutants();


    }

}
