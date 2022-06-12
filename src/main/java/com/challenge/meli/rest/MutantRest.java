package com.challenge.meli.rest;

import com.challenge.meli.model.common.DnaRequest;
import com.challenge.meli.services.mutant.MutantServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/mutant", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MutantRest {

    @Autowired
    private MutantServices mutantServices;

    @PostMapping
    public ResponseEntity<Boolean> isMutant(@RequestBody DnaRequest dna) {
        Boolean result = mutantServices.isMutant(dna);
        return ResponseEntity.status(result ? 200 : 403).body(result);
    }
}
