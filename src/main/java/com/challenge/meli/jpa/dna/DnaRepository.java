package com.challenge.meli.jpa.dna;

import com.challenge.meli.jpa.dna.model.MutantDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<MutantDto, Integer> { }
