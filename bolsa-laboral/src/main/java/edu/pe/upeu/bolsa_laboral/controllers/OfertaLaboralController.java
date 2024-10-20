package edu.pe.upeu.bolsa_laboral.controllers;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;
import edu.pe.upeu.bolsa_laboral.services.OfertaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaLaboralController {

    @Autowired
    private OfertaLaboralService ofertaLaboralService;

    @PostMapping
    public ResponseEntity<OfertaLaboral> createOfertaLaboral(@RequestBody OfertaLaboral ofertaLaboral) {
        OfertaLaboral createdOferta = ofertaLaboralService.save(ofertaLaboral);
        return ResponseEntity.ok(createdOferta);
    }

    @GetMapping
    public ResponseEntity<List<OfertaLaboral>> getAllOfertas() {
        List<OfertaLaboral> ofertas = ofertaLaboralService.findAll();
        return ResponseEntity.ok(ofertas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfertaLaboral> getOfertaById(@PathVariable Long id) {
        OfertaLaboral ofertaLaboral = ofertaLaboralService.findById(id);
        return ResponseEntity.ok(ofertaLaboral);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfertaLaboral> updateOferta(@RequestBody OfertaLaboral ofertaLaboral, @PathVariable Long id) {
        OfertaLaboral updatedOferta = ofertaLaboralService.update(ofertaLaboral, id);
        return ResponseEntity.ok(updatedOferta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOferta(@PathVariable Long id) {
        ofertaLaboralService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
