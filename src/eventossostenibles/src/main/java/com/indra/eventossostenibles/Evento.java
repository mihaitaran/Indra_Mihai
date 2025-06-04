package com.indra.eventossostenibles;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Evento {

    // Atributos
    protected String idEvento;
    protected String nombre;
    protected int duracion;
    protected LocalDateTime fecha;
    protected String tipo;
    protected ArrayList<Usuario> usuarios = new ArrayList<>();
    protected boolean activo = true; // Indica si el evento está activo o no

    // Constructor
    public Evento(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.duracion = duracion;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getId() {
        return idEvento;
    }

    public void setId(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }   

    // Métodos
    public String toString() {
        return nombre + ", ID: " + idEvento + ", Duración: " + duracion + " minutos, Fecha: " + fecha + ", Tipo: " + tipo 
               + ", Activo: " + activo;
    }

    // Método para inscribir un usuario al evento 
    public void agregarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    // Método para eliminar un usuario del evento
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
}
