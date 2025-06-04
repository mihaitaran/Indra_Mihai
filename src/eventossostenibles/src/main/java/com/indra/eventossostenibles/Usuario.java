package com.indra.eventossostenibles;

import java.util.ArrayList;

public class Usuario {

    // Atributos
    private String idUsuario;
    private String nombre;
    private String correo;
    private String contraseña;
    private ArrayList<Evento> eventos = new ArrayList<>();

    // Constructor
    public Usuario(String idUsuario, String nombre, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;

    }

    // Getters y Setters
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;

    }

    public String getId() {
        return idUsuario;
    }

    public void setId(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail(String correo) {
        this.correo = correo;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    // Filtrar eventos por tipo
    public void filtrarEventos(ArrayList<Evento> eventos, String tipo) {
        ArrayList<Evento> eventosFiltrados = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) {
                eventosFiltrados.add(evento);
            }
        }
        this.eventos = eventosFiltrados;
    }

    // Inscripción en eventos
    public void inscribirEvento(Evento evento) {
        if (!eventos.contains(evento)) {
            eventos.add(evento);
            evento.agregarUsuario(this);
        } else {
            System.out.println("Ya estás inscrito en este evento.");
        }
    }

    // Cancelar inscripción en eventos
    public void cancelarInscripcion(Evento evento) {
        if (eventos.contains(evento)) {
            eventos.remove(evento);
            evento.eliminarUsuario(this);
        } else {
            System.out.println("No estás inscrito en este evento.");
        }
    }

    public String toString() {
        return "Usuario: " + nombre + " (ID: " + idUsuario + ", Email: " + correo + ")";
    }
}
