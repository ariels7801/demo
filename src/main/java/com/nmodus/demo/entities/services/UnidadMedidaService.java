package com.nmodus.demo.entities.services;

import com.nmodus.demo.entities.models.UnidadMedida;
import com.nmodus.demo.entities.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService {

    private UnidadMedidaRepository unidadRepository;

    @Autowired
    public void setUnidadMedidaRepository(UnidadMedidaRepository unidadRepository){
        this.unidadRepository = unidadRepository;
    }

    public Iterable<UnidadMedida> all() {
        return unidadRepository.findAll();
    }

    public UnidadMedida find(Short id){
        return unidadRepository.findOne(id);
    }

    public void deleteUnidad(Short id){
        unidadRepository.delete(id);
    }

}
