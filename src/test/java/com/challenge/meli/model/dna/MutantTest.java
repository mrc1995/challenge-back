package com.challenge.meli.model.dna;

import org.junit.Assert;
import org.junit.Test;

public class MutantTest {

    @Test
    public void mutant() {
        Mutant mutant = new Mutant();
        mutant.setCountMutant(1);
        mutant.setCountHuman(0);

        Assert.assertNotNull(mutant.getCountMutant());
        Assert.assertNotNull(mutant.getCountHuman());
    }
}
