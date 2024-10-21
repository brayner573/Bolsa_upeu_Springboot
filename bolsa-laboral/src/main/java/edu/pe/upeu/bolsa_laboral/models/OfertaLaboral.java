package edu.pe.upeu.bolsa_laboral.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "oferta_laboral")
public class OfertaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/**
 * Custom exception to handle resources not found scenarios.
 * This exception will result in a 404 Not Found HTTP response status.
 */
    @NotNull
    @Size(max = 100)
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Size(max = 100)
    @Column(name = "empresa", nullable = false, length = 100)
    private String empresa;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_publicacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_cierre", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;

    @NotNull
    @Column(name = "salario", nullable = false)
    private Double salario;
}