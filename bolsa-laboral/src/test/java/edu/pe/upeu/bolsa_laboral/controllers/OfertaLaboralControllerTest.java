package edu.pe.upeu.bolsa_laboral.controllers;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;
import edu.pe.upeu.bolsa_laboral.services.OfertaLaboralService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class OfertaLaboralControllerTest {

    @InjectMocks
    private OfertaLaboralController ofertaLaboralController;

    @Mock
    private OfertaLaboralService ofertaLaboralService;

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
    public void testGetAllOfertas() {
        List<OfertaLaboral> listaOfertas = Arrays.asList(ofertaLaboral);

        // Simular el comportamiento del servicio
        given(ofertaLaboralService.findAll()).willReturn(listaOfertas);

        // Llamar al controlador y verificar la respuesta
        ResponseEntity<List<OfertaLaboral>> response = ofertaLaboralController.getAllOfertas();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Desarrollador Java", response.getBody().get(0).getTitulo());
    }

    @Test
    public void testCreateOferta() {
        given(ofertaLaboralService.save(Mockito.any(OfertaLaboral.class))).willReturn(ofertaLaboral);

        ResponseEntity<OfertaLaboral> response = ofertaLaboralController.createOfertaLaboral(ofertaLaboral);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Desarrollador Java", response.getBody().getTitulo());
    }
    @Test
    public void testGetOfertaByIdNotFound() {
    // Simular que el servicio lanza una excepción cuando la oferta no se encuentra xd
    given(ofertaLaboralService.findById(1L)).willThrow(new RuntimeException("Oferta no encontrada"));

    // Llamar al controlador y verificar que responde con un error 404 xsxsxsxsx
    Exception exception = assertThrows(RuntimeException.class, () -> {
        ofertaLaboralController.getOfertaById(1L);
    });

    assertEquals("Oferta no encontrada", exception.getMessage());
}
}
