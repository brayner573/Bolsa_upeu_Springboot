package edu.pe.upeu.bolsa_laboral.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.upeu.bolsa_laboral.exceptions.ResourceNotFoundException;
import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;
import edu.pe.upeu.bolsa_laboral.repositories.OfertaLaboralRepository;

@Service
@Transactional
public class OfertaLaboralServiceImpl implements OfertaLaboralService {

    @Autowired
    private OfertaLaboralRepository ofertaLaboralRepository;

    @Override
    public OfertaLaboral save(OfertaLaboral ofertaLaboral) {
        return ofertaLaboralRepository.save(ofertaLaboral);
    }

    @Override
    public List<OfertaLaboral> findAll() {
        return ofertaLaboralRepository.findAll();
    }

    @Override
    public OfertaLaboral findById(Long id) {
        return ofertaLaboralRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Oferta no encontrada con el id: " + id));
    }

    @Override
    public OfertaLaboral update(OfertaLaboral ofertaLaboral, Long id) {
        OfertaLaboral existingOferta = ofertaLaboralRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Oferta no encontrada con el id: " + id));
        
        existingOferta.setTitulo(ofertaLaboral.getTitulo());
        existingOferta.setDescripcion(ofertaLaboral.getDescripcion());
        existingOferta.setEmpresa(ofertaLaboral.getEmpresa());
        existingOferta.setFechaPublicacion(ofertaLaboral.getFechaPublicacion());
        existingOferta.setFechaCierre(ofertaLaboral.getFechaCierre());
        existingOferta.setSalario(ofertaLaboral.getSalario());

        return ofertaLaboralRepository.save(existingOferta);
    }

    @Override
    public void delete(Long id) {
        OfertaLaboral ofertaLaboral = ofertaLaboralRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Oferta no encontrada con el id: " + id));
        
        ofertaLaboralRepository.delete(ofertaLaboral);
    }
}
