package com.indra.eventossostenibles;

import java.time.LocalDateTime;

public class Online extends Evento {

    // Atributos específicos de Evento Online
    private String sitioWeb;

    // Constructor
    public Online(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo, String sitioWeb) {
        super(idEvento, nombre, duracion, fecha, tipo);
        this.sitioWeb = sitioWeb;
    }

    // Getters y Setters
    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String toString() {
        return "Evento Online: " + super.toString() + ", Sitio Web: " + sitioWeb;
    }
}
