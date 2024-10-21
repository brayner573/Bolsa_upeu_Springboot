package edu.pe.upeu.bolsa_laboral.dtos;

import java.util.Date;

public class OfertaLaboralDto {
    private Long id;
    private String titulo;
    private String descripcion;
    private String empresa;
    private Double salario;
    private Date fechaPublicacion;
    private Date fechaCierre;

    // Constructor vacío
    public OfertaLaboralDto() {
    }

    // Constructor con parámetros
    public OfertaLaboralDto(Long id, String titulo, String descripcion, String empresa, Double salario, Date fechaPublicacion, Date fechaCierre) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.salario = salario;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaCierre = fechaCierre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
