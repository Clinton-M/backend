package com.marber.backend.controller;

import com.marber.backend.entities.Producto;
import com.marber.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    /*
    @GetMapping("/nombre/{nombre}")
    public List<Producto> getProductoByNombre(@PathVariable String nombre) {
        return productoService.getProductoByNombre(nombre);
    }
     */

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) throws ChangeSetPersister.NotFoundException {
        return productoService.updateProducto(id, productoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        productoService.deleteProducto(id);
    }


}
