package com.nmodus.demo.entities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UnidadMedida")
public class UnidadMedida {

    @Id
    @GeneratedValue
    @Column(name = "UnidadMedida_Id")
    private short id;

    @Column(name = "Nombre")
    private String nombre;

    @OneToMany(mappedBy = "unidad_medida", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Producto> productos = new ArrayList<Producto>();

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonIgnore
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
