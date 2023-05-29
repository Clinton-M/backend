package com.marber.backend.service;


import com.marber.backend.entities.Producto;
import com.marber.backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) throws ChangeSetPersister.NotFoundException {
        return productoRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto productoDetails) throws ChangeSetPersister.NotFoundException {
        Producto producto = getProductoById(id);
        // Set the updated fields of the producto object
        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setCantidadEnStock(productoDetails.getCantidadEnStock());
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) throws ChangeSetPersister.NotFoundException {
        Producto producto = getProductoById(id);
        productoRepository.delete(producto);
    }
}