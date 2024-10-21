package edu.pe.upeu.bolsa_laboral.repositories;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OfertaLaboralRepositoryIntegrationTest {

    @Autowired
    private OfertaLaboralRepository ofertaLaboralRepository;

    private OfertaLaboral ofertaLaboral;

    @BeforeEach
    public void setUp() {
        // Limpiar la base de datos antes de cada prueba
        ofertaLaboralRepository.deleteAll();
        
        // Crear una oferta laboral de ejemplo
        ofertaLaboral = new OfertaLaboral();
        ofertaLaboral.setTitulo("Desarrollador Java");
        ofertaLaboral.setDescripcion("Desarrollador Java con experiencia.");
        ofertaLaboral.setEmpresa("Empresa XYZ");
        ofertaLaboral.setFechaPublicacion(new Date());
        ofertaLaboral.setFechaCierre(new Date());
        ofertaLaboral.setSalario(5000.0);
        
        ofertaLaboralRepository.save(ofertaLaboral);
    }

    @Test
    public void testFindAll() {
        List<OfertaLaboral> ofertas = ofertaLaboralRepository.findAll();
        assertEquals(1, ofertas.size());
        assertEquals("Desarrollador Java", ofertas.get(0).getTitulo());
    }

    @Test
    public void testFindById() {
        OfertaLaboral oferta = ofertaLaboralRepository.findById(ofertaLaboral.getId()).orElse(null);
        assertNotNull(oferta);
        assertEquals("Desarrollador Java", oferta.getTitulo());
    }

    @Test
    public void testCreateOferta() {
        OfertaLaboral nuevaOferta = new OfertaLaboral();
        nuevaOferta.setTitulo("Analista de Datos");
        nuevaOferta.setDescripcion("Experiencia en SQL");
        nuevaOferta.setEmpresa("Empresa ABC");
        nuevaOferta.setFechaPublicacion(new Date());
        nuevaOferta.setFechaCierre(new Date());
        nuevaOferta.setSalario(4500.0);

        OfertaLaboral createdOferta = ofertaLaboralRepository.save(nuevaOferta);
        assertNotNull(createdOferta);
        assertEquals("Analista de Datos", createdOferta.getTitulo());
    }

    @Test
    public void testDeleteOferta() {
        ofertaLaboralRepository.delete(ofertaLaboral);
        List<OfertaLaboral> ofertas = ofertaLaboralRepository.findAll();
        assertEquals(0, ofertas.size());
    }
}
