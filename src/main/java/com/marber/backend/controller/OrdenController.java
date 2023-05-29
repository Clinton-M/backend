package com.marber.backend.controller;

import com.marber.backend.entities.Orden;
import com.marber.backend.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenService ordenService;

    @Autowired
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public Orden getOrdenById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ordenService.getOrdenById(id);
    }

    @PostMapping
    public Orden createOrden(@RequestBody Orden orden) {
        return ordenService.createOrden(orden);
    }

    @PutMapping("/{id}")
    public Orden updateOrden(@PathVariable Long id, @RequestBody Orden ordenDetails) throws ChangeSetPersister.NotFoundException {
        return ordenService.updateOrden(id, ordenDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrden(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        ordenService.deleteOrden(id);
    }




}
