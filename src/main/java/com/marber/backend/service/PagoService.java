package com.marber.backend.service;

import com.marber.backend.entities.Pago;
import com.marber.backend.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;
    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Pago getPagoById(Long id) throws ChangeSetPersister.NotFoundException {
        return pagoRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago updatePago(Long id, Pago pagoDetails) throws ChangeSetPersister.NotFoundException {
        Pago pago = getPagoById(id);
        // Set the updated fields of the pago object
        pago.setFechaPago(pagoDetails.getFechaPago());
        pago.setMonto(pagoDetails.getMonto());
        pago.setMetodoPago(pagoDetails.getMetodoPago());
        pago.setOrden(pagoDetails.getOrden());
        return pagoRepository.save(pago);
    }

    public void deletePago(Long id) throws ChangeSetPersister.NotFoundException {
        Pago pago = getPagoById(id);
        pagoRepository.delete(pago);
    }
}