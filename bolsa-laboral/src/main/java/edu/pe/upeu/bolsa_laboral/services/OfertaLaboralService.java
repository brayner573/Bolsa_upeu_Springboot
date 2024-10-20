package edu.pe.upeu.bolsa_laboral.services;

import java.util.List;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;

public interface OfertaLaboralService {
    OfertaLaboral save(OfertaLaboral ofertaLaboral);
    List<OfertaLaboral> findAll();
    OfertaLaboral findById(Long id);
    OfertaLaboral update(OfertaLaboral ofertaLaboral, Long id);
    void delete(Long id);
}