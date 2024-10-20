package edu.pe.upeu.bolsa_laboral.controllers;

import edu.pe.upeu.bolsa_laboral.models.OfertaLaboral;
import edu.pe.upeu.bolsa_laboral.repositories.OfertaLaboralRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfertaLaboralControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private OfertaLaboralRepository ofertaLaboralRepository;

    private OfertaLaboral ofertaLaboral;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        
        // Limpiar la base de datos antes de cada prueba
        ofertaLaboralRepository.deleteAll();
        
        // Crear una oferta laboral para usar en las pruebas
        ofertaLaboral = new OfertaLaboral();
        ofertaLaboral.setTitulo("Desarrollador Java");
        ofertaLaboral.setDescripcion("Desarrollador Java con 3 años de experiencia.");
        ofertaLaboral.setEmpresa("Empresa XYZ");
        ofertaLaboral.setFechaPublicacion(new Date());
        ofertaLaboral.setFechaCierre(new Date());
        ofertaLaboral.setSalario(5000.0);
        ofertaLaboralRepository.save(ofertaLaboral);
    }

    @Test
    public void testGetAllOfertas() {
        given()
            .when().get("/api/ofertas")
            .then()
            .statusCode(200)
            .body("size()", is(1))
            .body("[0].titulo", equalTo("Desarrollador Java"));
    }

    @Test
    public void testGetOfertaById() {
        Long id = ofertaLaboral.getId();
        given()
            .when().get("/api/ofertas/{id}", id)
            .then()
            .statusCode(200)
            .body("titulo", equalTo("Desarrollador Java"))
            .body("empresa", equalTo("Empresa XYZ"));
    }

    @Test
    public void testCreateOfertaLaboral() {
        OfertaLaboral newOferta = new OfertaLaboral();
        newOferta.setTitulo("Analista de Datos");
        newOferta.setDescripcion("Analista con experiencia en Python y SQL.");
        newOferta.setEmpresa("Empresa ABC");
        newOferta.setFechaPublicacion(new Date());
        newOferta.setFechaCierre(new Date());
        newOferta.setSalario(4500.0);

        given()
            .contentType(ContentType.JSON)
            .body(newOferta)
            .when().post("/api/ofertas")
            .then()
            .statusCode(200)
            .body("titulo", equalTo("Analista de Datos"))
            .body("empresa", equalTo("Empresa ABC"));
    }

    @Test
    public void testUpdateOfertaLaboral() {
        Long id = ofertaLaboral.getId();
        ofertaLaboral.setTitulo("Desarrollador Full Stack");

        given()
            .contentType(ContentType.JSON)
            .body(ofertaLaboral)
            .when().put("/api/ofertas/{id}", id)
            .then()
            .statusCode(200)
            .body("titulo", equalTo("Desarrollador Full Stack"));
    }

    @Test
    public void testDeleteOfertaLaboral() {
        Long id = ofertaLaboral.getId();

        given()
            .when().delete("/api/ofertas/{id}", id)
            .then()
            .statusCode(204);

        List<OfertaLaboral> allOfertas = ofertaLaboralRepository.findAll();
        assertEquals(0, allOfertas.size());
    }
}
