package com.edu.uceva.locomotoraservise.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Locomotora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo modelo no puede estar vacio")
    @Size(min = 2, max = 50, message = "El campo modelo debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String modelo;

    @NotEmpty(message = "El campo fabricante no puede estar vacio")
    @Size(min = 2, max = 50, message = "El campo fabricante debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String fabricante;

    @Min(value = 1885, message = "El año de fabricación debe ser mayor o igual a 1885")
    @NotNull(message = "El campo año de fabricación no puede estar vacio")
    @Column(nullable = false)
    private int anioFabricacion;

    @NotEmpty(message = "El campo tipo de combustible no puede estar vacio")
    @Size(min = 2, max = 30, message = "El campo tipo de combustible debe tener entre 2 y 30 caracteres")
    @Column(nullable = false)
    private String tipoCombustible;

    @Min(value = 6000, message = "La potencia debe ser mayor o igual a 6000 caballos de fuerza")
    @NotNull(message = "El campo potencia no puede estar vacio")
    @Column(nullable = false)
    private int potencia;

    @NotEmpty(message = "El campo estado no puede estar vacio")
    @Size(min = 2, max = 20, message = "El campo estado debe tener entre 2 y 20 caracteres")
    @Column(nullable = false)
    private String estado;
}
