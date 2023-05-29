package com.marber.backend.controller;

import com.marber.backend.entities.Factura;
import com.marber.backend.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.getAllFacturas();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return facturaService.getFacturaById(id);
    }
    /*
    @GetMapping("/cliente/{id}")
    public List<Factura> getFacturasByClienteId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return facturaService.getFacturasByClienteId(id);
    }
     */

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.createFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura facturaDetails) throws ChangeSetPersister.NotFoundException {
        return facturaService.updateFactura(id, facturaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        facturaService.deleteFactura(id);
    }


}
