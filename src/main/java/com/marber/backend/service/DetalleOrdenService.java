package com.marber.backend.service;

import com.marber.backend.entities.DetalleOrden;
import com.marber.backend.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOrdenService {
    private final DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    public DetalleOrdenService(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    public List<DetalleOrden> getAllDetalleOrdenes(){
        return detalleOrdenRepository.findAll();
    }

    public DetalleOrden getDetalleOrdenById(Long id) throws ChangeSetPersister.NotFoundException {
        return detalleOrdenRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public DetalleOrden createDetalleOrden(DetalleOrden detalleOrden){
        return detalleOrdenRepository.save(detalleOrden);
    }

    public DetalleOrden updateDetalleOrden(Long id, DetalleOrden detalleOrdenDetails) throws ChangeSetPersister.NotFoundException {
        DetalleOrden detalleOrden = getDetalleOrdenById(id);
        // Set the updated fields of the detalleOrden object
        detalleOrden.setCantidad(detalleOrdenDetails.getCantidad());
        detalleOrden.setPrecio(detalleOrdenDetails.getPrecio());
        detalleOrden.setProducto(detalleOrdenDetails.getProducto());
        detalleOrden.setOrden(detalleOrdenDetails.getOrden());
        return detalleOrdenRepository.save(detalleOrden);
    }

    public void deleteDetalleOrden(Long id) throws ChangeSetPersister.NotFoundException {
        DetalleOrden detalleOrden = getDetalleOrdenById(id);
        detalleOrdenRepository.delete(detalleOrden);
    }




}
