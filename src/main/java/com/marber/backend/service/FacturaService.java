package com.marber.backend.service;

import com.marber.backend.entities.Factura;
import com.marber.backend.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Factura getFacturaById(Long id) throws ChangeSetPersister.NotFoundException {
        return facturaRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Factura createFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura updateFactura(Long id, Factura facturaDetails) throws ChangeSetPersister.NotFoundException {
        Factura factura = getFacturaById(id);
        // Set the updated fields of the factura object
        factura.setFechaFactura(facturaDetails.getFechaFactura());
        factura.setTotal(facturaDetails.getTotal());
        factura.setRuc(facturaDetails.getRuc());
        factura.setOrden(facturaDetails.getOrden());
        return facturaRepository.save(factura);
    }

    public void deleteFactura(Long id) throws ChangeSetPersister.NotFoundException {
        Factura factura = getFacturaById(id);
        facturaRepository.delete(factura);
    }
}
