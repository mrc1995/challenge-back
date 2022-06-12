package com.challenge.meli.services.mutant.impl;

import com.challenge.meli.jpa.dna.DnaRepository;
import com.challenge.meli.jpa.dna.model.MutantDto;
import com.challenge.meli.model.common.DnaRequest;
import com.challenge.meli.model.dna.Mutant;
import com.challenge.meli.services.mutant.MutantServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MutantServicesImpl implements MutantServices {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private DnaRepository dnaRepository;

    private String [][] convertStringToArray(String[] adnMutant) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (String adn: adnMutant) {
            String[] splitAdn = adn.split("");
            arrayList.add(splitAdn);
        }
        return arrayList.toArray(new String[adnMutant.length][]);
    }

    public boolean isMutant(DnaRequest dna) {
        String[][] adn = convertStringToArray(dna.getDna());
        int countMutant = 0;
        boolean mod = (adn.length % 2 == 0);
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < (adn[i].length - 3); j++) {
                if (i < (adn.length - 3) && (adn[i][j].equals(adn[i + 1][j + 1]) &&
                        adn[i][j].equals(adn[i + 2][j + 2]) &&
                        adn[i][j].equals(adn[i + 3][j + 3]))) {
                    countMutant++;
                }
                if (adn[i][j].equals(adn[i][j + 1]) &&
                        adn[i][j].equals(adn[i][j + 2]) &&
                        adn[i][j].equals(adn[i][j + 3])) {
                    countMutant++;
                }
            }
            for (int j = 0; j < adn[i].length; j++) {
                if (i < (adn.length - (mod ? 4 : 3)) && adn[i][j].equals(adn[i + 1][j]) &&
                        adn[i][j].equals(adn[i + 2][j]) &&
                        adn[i][j].equals(adn[i + 3][j])) {
                    countMutant++;
                }
            }
        }
        saveMutantOrHuman(countMutant);
        return countMutant > 1 ? true : false;
    }


    private void saveMutantOrHuman(int countMutant) {
        Mutant mutant = new Mutant();
        mutant.setCountMutant(countMutant > 1 ? 1: 0);
        mutant.setCountHuman(countMutant > 1 ? 0 : 1);
        dnaRepository.save(mapper.convertValue(mutant, MutantDto.class));
    }
}
