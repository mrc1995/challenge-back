package com.challenge.meli.rest;

import com.challenge.meli.model.common.DnaRequest;
import com.challenge.meli.services.mutant.MutantServices;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(classes = MutantRest.class)
public class MutantRestTest {

    @Mock
    private MutantServices mutantServices;

    @InjectMocks
    private MutantRest mutantRest;


    @Test
    public void isMutant() {
        String[] testMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(testMutant);
        Mockito.when(mutantServices.isMutant(dnaRequest)).thenReturn(true);
        ResponseEntity<Boolean> isMutantTest = mutantRest.isMutant(dnaRequest);
    }

    @Test
    public void isHuman() {
        String[] testMutant = {"ATGCGA","CGGTGC","TTATGT","AGAAGG","CCGCTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(testMutant);
        Mockito.when(mutantServices.isMutant(dnaRequest)).thenReturn(true);
        ResponseEntity<Boolean> isMutantTest = mutantRest.isMutant(dnaRequest);
    }

}
