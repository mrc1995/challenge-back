package com.challenge.meli.model.stats;

import org.junit.Assert;
import org.junit.Test;

public class StatsTest {

    @Test
    public void stats(){
        Stats stats = new Stats();
        stats.setRatio(0.4);
        stats.setCount_human_dna(40);
        stats.setCount_mutant_dna(100);

        Assert.assertNotNull(stats.getCount_human_dna());
        Assert.assertNotNull(stats.getCount_mutant_dna());
        Assert.assertNotNull(stats.getRatio());
    }
}
