package com.challenge.meli.services.mutant;

import com.challenge.meli.jpa.dna.DnaRepository;
import com.challenge.meli.model.common.DnaRequest;
import com.challenge.meli.services.mutant.MutantServices;
import com.challenge.meli.services.mutant.impl.MutantServicesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = MutantServicesImpl.class)
public class MutantServicesTest {

    @Mock
    private ObjectMapper mapper;

    @Mock
    private DnaRepository dnaRepository;

    @InjectMocks
    private MutantServicesImpl mutantServicesImpl;


    @Test
    public void isMutantTest() {
        String[] testMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(testMutant);
        Boolean result = mutantServicesImpl.isMutant(dnaRequest);
        Assert.assertTrue(result);
    }

    @Test
    public void isMutantFalseTest() {
        String[] testMutant = {"ATGCGA","CGGTGC","TTATGT","AGAAGG","CCTCTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(testMutant);
        Boolean result = mutantServicesImpl.isMutant(dnaRequest);
        Assert.assertFalse(result);
    }
}
