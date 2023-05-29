package com.marber.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaFactura;

    private Double total;

    private String ruc;

    @ManyToOne
    private Orden orden;
}