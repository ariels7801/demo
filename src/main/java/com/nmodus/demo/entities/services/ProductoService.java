package com.nmodus.demo.entities.services;

import com.nmodus.demo.entities.models.Producto;
import com.nmodus.demo.entities.models.UnidadMedida;
import com.nmodus.demo.entities.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto find(int id){
        return this.productoRepository.findOne(id);
    }

    public Producto findByIdUnidad(int id, UnidadMedida unidad){
        return this.productoRepository.findByUnidad_medida(id, unidad);
    }

    public Iterable<Producto> all(){
        return this.productoRepository.findAll();
    }

}
