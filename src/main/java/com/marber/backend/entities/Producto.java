package com.marber.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String imagen;
    private String descripcion;
    private Double precio;

    private Integer cantidadEnStock;
}