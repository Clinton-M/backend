package com.marber.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;

    private Integer cantidad;

    private Double precio;
}