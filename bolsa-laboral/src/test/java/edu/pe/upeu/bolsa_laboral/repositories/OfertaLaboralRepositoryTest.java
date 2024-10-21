package edu.pe.upeu.bolsa_laboral.repositories;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class OfertaLaboralRepositoryTest {

    @Mock
    private OfertaLaboralRepository ofertaLaboralRepository;

    private OfertaLaboral ofertaLaboral;

    @BeforeEach
    public void setUp() {
        ofertaLaboral = new OfertaLaboral();
        ofertaLaboral.setId(1L);
        ofertaLaboral.setTitulo("Desarrollador Java");
        ofertaLaboral.setDescripcion("Con 3 años de experiencia.");
        ofertaLaboral.setEmpresa("Empresa XYZ");
        ofertaLaboral.setSalario(5000.0);
    }

    @Test
    public void testFindById() {
        given(ofertaLaboralRepository.findById(1L)).willReturn(Optional.of(ofertaLaboral));

        Optional<OfertaLaboral> result = ofertaLaboralRepository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    public void testFindAll() {
        List<OfertaLaboral> ofertas = List.of(ofertaLaboral);

        given(ofertaLaboralRepository.findAll()).willReturn(ofertas);

        List<OfertaLaboral> result = ofertaLaboralRepository.findAll();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}
