package com.indra.eventossostenibles;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Organizador {

    // Atributos
    private String idOrganizador;
    private String nombre;
    private String correo;
    private String telefono;
    private ArrayList<Evento> eventos = new ArrayList<>();

    // Constructor
    public Organizador(String idOrganizador, String nombre, String correo, String telefono) {
        this.idOrganizador = idOrganizador;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getId() {
        return idOrganizador;
    }

    public void setId(String idOrganizador) {
        this.idOrganizador = idOrganizador;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    // Métodos para crear eventos físicos
    public Evento crearEvento(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo,
            String lugar, String ciudad, String provincia) {

        Evento evento = new Fisico(idEvento, nombre, duracion, fecha, tipo, lugar, ciudad, provincia);

        eventos.add(evento);

        return evento;
    }

    // Métodos para crear eventos online
    public Evento crearEvento(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo,
            String sitioWeb) {

        Evento evento = new Online(idEvento, nombre, duracion, fecha, tipo, sitioWeb);

        eventos.add(evento);

        return evento;
    }

    // Método para cancelar un evento
    public void cancelarEvento(String idEvento) {
        boolean eventoEncontrado = false;

        for (Evento evento : eventos) {
            if (evento.getId().equals(idEvento)) {
                evento.setActivo(false);
                eventoEncontrado = true;
                System.out.println("Evento con ID " + idEvento + " ha sido cancelado.");
                break;
            }
        }

        if (!eventoEncontrado) {
            System.out.println("Evento con ID " + idEvento + " no encontrado.");
        }
    }

    // Método para obtener eventos activos
    public ArrayList<Evento> getEventosActivos() {
        ArrayList<Evento> eventosActivos = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.isActivo()) {
                eventosActivos.add(evento);
            }
        }
        return eventosActivos;
    }

    // Métodos para modificar eventos físicos
    public void modificarEvento(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo,
            String lugar, String ciudad, String provincia) {

        boolean eventoEncontrado = false;

        for (Evento evento : eventos) {
            if (evento.getId().equals(idEvento)) {
                evento.setNombre(nombre);
                evento.setDuracion(duracion);
                evento.setFecha(fecha);
                evento.setTipo(tipo);
                eventoEncontrado = true;
                if (evento instanceof Fisico) {
                    Fisico fisico = (Fisico) evento;
                    fisico.setLugar(lugar);
                    fisico.setCiudad(ciudad);
                    fisico.setProvincia(provincia);
                }
            }
        }

        if (!eventoEncontrado) {
            System.out.println("Evento con ID " + idEvento + " no encontrado.");
        }
    }

    // Métodos para modificar eventos online
    public void modificarEvento(String idEvento, String nombre, int duracion, LocalDateTime fecha, String tipo,
            String sitioWeb) {

        boolean eventoEncontrado = false;

        for (Evento evento : eventos) {
            if (evento.getId().equals(idEvento)) {
                evento.setNombre(nombre);
                evento.setDuracion(duracion);
                evento.setFecha(fecha);
                evento.setTipo(tipo);
                eventoEncontrado = true;
                if (evento instanceof Online) {
                    Online online = (Online) evento;
                    online.setSitioWeb(sitioWeb);
                }
            }
        }

        if (!eventoEncontrado) {
            System.out.println("Evento con ID " + idEvento + " no encontrado.");
        }
    }

    public String toString() {
        return "Organizador: " + nombre + ", Email: " + correo + ", Telefono: " + telefono + ", Eventos: " + eventos;
    }
}
