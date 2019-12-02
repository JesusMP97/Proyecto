package org.izv.proyecto.model.data;

import java.io.Serializable;

public class Mesa implements Serializable {
    private long id, numero, estado, capacidad;
    private String zona;

    public Mesa(long id, long numero, long estado, long capacidad, String zona) {                   // + Jesus
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.capacidad = capacidad;
        this.zona = zona;
    }                                                                                               // - Jesus

    public long getId() {
        return id;
    }

    public Mesa setId(long id) {
        this.id = id;
        return this;
    }

    public long getNumero() {
        return numero;
    }

    public Mesa setNumero(long numero) {
        this.numero = numero;
        return this;
    }

    public long getEstado() {
        return estado;
    }

    public Mesa setEstado(long estado) {
        this.estado = estado;
        return this;
    }

    public String getZona() {
        return zona;
    }

    public Mesa setZona(String zona) {
        this.zona = zona;
        return this;
    }

    public long getCapacidad() {
        return capacidad;
    }

    public Mesa setCapacidad(long capacidad) {
        this.capacidad = capacidad;
        return this;
    }
}
