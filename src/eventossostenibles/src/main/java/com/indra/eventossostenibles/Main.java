package com.indra.eventossostenibles;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Crear organizadores
        Organizador org1 = new Organizador("ORG001", "Ana Gómez", "ana@eventos.com", "123456789");
        Organizador org2 = new Organizador("ORG002", "Carlos Pérez", "carlos@eventos.com", "987654321");

        // Crear un evento físico y uno online para cada organizador
        Evento evento1 = org1.crearEvento("EVT001", "Conferencia Verde", 120,
                LocalDateTime.of(2025, 6, 10, 10, 0), "Fisico", "Auditorio A", "Madrid", "Madrid");
        Evento evento2 = org1.crearEvento("EVT002", "Webinar Energía", 90,
                LocalDateTime.of(2025, 6, 15, 17, 0), "Online", "https://webinarenergia.com");

        Evento evento3 = org2.crearEvento("EVT003", "Feria Sostenible", 150,
                LocalDateTime.of(2025, 7, 5, 9, 0), "Fisico", "Palacio Congresos", "Barcelona", "Cataluña");
        Evento evento4 = org2.crearEvento("EVT004", "Taller Clima", 60,
                LocalDateTime.of(2025, 7, 12, 11, 0), "Online", "https://tallerclima.com");

        // Crear usuarios
        Usuario user1 = new Usuario("USR001", "Lucía", "lucia@gmail.com", "pass1");
        Usuario user2 = new Usuario("USR002", "Miguel", "miguel@gmail.com", "pass2");
        Usuario user3 = new Usuario("USR003", "Laura", "laura@gmail.com", "pass3");
        Usuario user4 = new Usuario("USR004", "Pedro", "pedro@gmail.com", "pass4");

        // Inscribir usuarios en eventos
        user1.inscribirEvento(evento1);
        user1.inscribirEvento(evento2);

        user2.inscribirEvento(evento3);
        user2.inscribirEvento(evento4);

        user3.inscribirEvento(evento2);
        user4.inscribirEvento(evento3);

        // Mostrar eventos de organizadores
        System.out.println(org1);
        System.out.println(org2);

        // Mostrar eventos inscritos por usuarios
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);

        for (Evento e : user1.getEventos()) {
            System.out.println("Evento inscrito por " + user1.getNombre() + ": " + e);
        }

        // Cancelar inscripción
        user1.cancelarInscripcion(evento1);

        for (Evento e : user1.getEventos()) {
            System.out.println("Evento inscrito por " + user1.getNombre() + ": " + e);
        }

        // Filtrar eventos online de org2 para user2
        user2.filtrarEventos(org2.getEventos(), "Online");
        System.out.println("Eventos online filtrados de org2 para " + user2.getNombre() + ":");
        for (Evento e : user2.getEventos()) {
            System.out.println(e);
        }

        // Modificar evento físico de org1
        org1.modificarEvento("EVT001", "Conferencia Verde PLUS", 130,
                LocalDateTime.of(2025, 6, 11, 10, 0), "Fisico", "Sala Eco", "Madrid", "Madrid");

        // Modificar evento online de org2
        org2.modificarEvento("EVT004", "Taller Clima Extendido", 75,
                LocalDateTime.of(2025, 7, 13, 11, 0), "Online", "https://tallerclima2025.com");

        // Mostrar organizadores tras modificaciones
        System.out.println("Después de modificaciones:");
        System.out.println(org1);
        System.out.println(org2);

        // Cancelar evento de org2
        org2.cancelarEvento("EVT003");

        // Mostrar organizadores tras cancelación
        evento3.isActivo();

        System.out.println("\nDespués de modificaciones y eliminación:");
        System.out.println(org1);
        System.out.println(org2);
    }
}