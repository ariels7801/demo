package com.nmodus.demo.entities.repositories;


import com.nmodus.demo.entities.models.Producto;
import com.nmodus.demo.entities.models.UnidadMedida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.unidad_medida = :unidad AND p.id =  :producto")
    Producto findByUnidad_medida(@Param("producto") int producto, @Param("unidad")UnidadMedida unidad);
}
