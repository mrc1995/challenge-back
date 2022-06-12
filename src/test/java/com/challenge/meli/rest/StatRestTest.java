package com.challenge.meli.rest;

import com.challenge.meli.model.stats.Stats;
import com.challenge.meli.services.stats.StatsServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(classes = StatRest.class)
public class StatRestTest {

    @Mock
    private StatsServices statsServices;

    @InjectMocks
    private StatRest statRest;

    @Test
    public void getStats() {
        Stats stastResponse = statRest.getStats();
        Assert.assertNull(stastResponse);
    }
}
