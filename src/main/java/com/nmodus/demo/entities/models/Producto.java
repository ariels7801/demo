package com.nmodus.demo.entities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Producto_Id")
    private int id;

    @Column(name = "Codigo")
    private String codigo;

    @Column(name = "Nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="UnidadMedida_Id")
    private UnidadMedida unidad_medida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonIgnore
    public UnidadMedida getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(UnidadMedida unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
}
