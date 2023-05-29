package com.marber.backend.controller;


import com.marber.backend.entities.DetalleOrden;
import com.marber.backend.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DetalleOrdenController {
    private final DetalleOrdenService detalleOrdenService;

    @Autowired
    public DetalleOrdenController(DetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }

    @GetMapping
    public List<DetalleOrden> getAllDetalleOrdenes() {
        return detalleOrdenService.getAllDetalleOrdenes();
    }

    @GetMapping("/{id}")
    public DetalleOrden getDetalleOrdenById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return detalleOrdenService.getDetalleOrdenById(id);
    }

    @PostMapping
    public DetalleOrden createDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        return detalleOrdenService.createDetalleOrden(detalleOrden);
    }

    @PutMapping("/{id}")
    public DetalleOrden updateDetalleOrden(@PathVariable Long id, @RequestBody DetalleOrden detalleOrdenDetails) throws ChangeSetPersister.NotFoundException {
        return detalleOrdenService.updateDetalleOrden(id, detalleOrdenDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleOrden(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        detalleOrdenService.deleteDetalleOrden(id);
    }

}
