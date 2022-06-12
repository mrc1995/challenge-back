package com.challenge.meli.model.common;

import org.junit.Assert;
import org.junit.Test;

public class DnaRequestTest {

    @Test
    public void testDnaRequest(){
        String[] testMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();

        dnaRequest.setDna(testMutant);

        Assert.assertNotNull(dnaRequest.getDna());

    }
}
