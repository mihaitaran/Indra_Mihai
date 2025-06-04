package com.indra.eventossostenibles;

import java.time.LocalDateTime;

public class Fisico extends Evento {

    // Atributos específicos de Evento Físico
    private String lugar;
    private String ciudad;
    private String provincia;

    // Constructor
    public Fisico(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo, String lugar, String ciudad, String provincia) {
        super(idEvento, nombre, duracion, fecha, tipo);
        this.lugar = lugar;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    // Getters y Setters
    public String getLugar() {
        return lugar;
    }   

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }   

    public String getCiudad() {
        return ciudad;
    }   

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }   

    public String getProvincia() {
        return provincia;
    }   

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }   

    public String toString() {
        return "Evento Fisico: " + super.toString() + ", Lugar: " + lugar + ", Ciudad: " + ciudad + ", Provincia: " + provincia;
    }

}
