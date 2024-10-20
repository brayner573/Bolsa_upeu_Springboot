package edu.pe.upeu.bolsa_laboral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;

@Repository
public interface OfertaLaboralRepository extends JpaRepository<OfertaLaboral, Long> {
}