package com.marber.backend.service;

import com.marber.backend.entities.Orden;
import com.marber.backend.repository.OrdenRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {
    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }
    public List<Orden> getAllOrdenes(){
        return ordenRepository.findAll();
    }

    public Orden getOrdenById(Long id) throws ChangeSetPersister.NotFoundException {
        return ordenRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

    }

    public Orden createOrden(Orden orden){
        return ordenRepository.save(orden);
    }

    public Orden updateOrden(Long id, Orden ordenDetails) throws ChangeSetPersister.NotFoundException {
        Orden orden = getOrdenById(id);
        // Set the updated fields of the orden object
        orden.setFechaCompra(ordenDetails.getFechaCompra());
        orden.setCliente(ordenDetails.getCliente());
        return ordenRepository.save(orden);
    }

    public void deleteOrden(Long id) throws ChangeSetPersister.NotFoundException {
        Orden orden = getOrdenById(id);
        ordenRepository.delete(orden);
    }


}
