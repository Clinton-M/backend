package com.marber.backend.controller;

import com.marber.backend.entities.Pago;
import com.marber.backend.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return pagoService.getPagoById(id);
    }

    /*
    @GetMapping("/cliente/{id}")
    public List<Pago> getPagosByClienteId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return pagoService.getPagosByClienteId(id);
    }
     */

    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoService.createPago(pago);
    }

    @PutMapping("/{id}")
    public Pago updatePago(@PathVariable Long id, @RequestBody Pago pagoDetails) throws ChangeSetPersister.NotFoundException {
        return pagoService.updatePago(id, pagoDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        pagoService.deletePago(id);
    }
}
