package com.indra.eventossostenibles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrganizadorTest {
    private Organizador organizador;

    @BeforeEach
    public void setUp() {
        organizador = new Organizador("org1", "Juan Perez", "juan@email.com", "123456789");
    }

    @Test
    public void testCrearEventoFisico() {
        Evento evento = organizador.crearEvento("ev1", "Eco Feria", 3, LocalDateTime.now(), "Feria", "Centro", "Madrid", "Madrid");
        assertTrue(evento instanceof Fisico);
        assertEquals(1, organizador.getEventos().size());
        assertEquals("ev1", evento.getId());
    }

    @Test
    public void testCrearEventoOnline() {
        Evento evento = organizador.crearEvento("ev2", "Webinar Verde", 2, LocalDateTime.now(), "Webinar", "www.webinar.com");
        assertTrue(evento instanceof Online);
        assertEquals(1, organizador.getEventos().size());
        assertEquals("ev2", evento.getId());
    }

    @Test
    public void testCancelarEvento() {
        organizador.crearEvento("ev3", "Taller", 1, LocalDateTime.now(), "Taller", "Aula", "Sevilla", "Sevilla");
        organizador.cancelarEvento("ev3");
        assertFalse(organizador.getEventos().get(0).isActivo());
    }

    @Test
    public void testGetEventosActivos() {
        organizador.crearEvento("ev4", "Charla", 2, LocalDateTime.now(), "Charla", "Sala", "Valencia", "Valencia");
        organizador.crearEvento("ev5", "Seminario", 2, LocalDateTime.now(), "Seminario", "www.seminario.com");
        organizador.cancelarEvento("ev4");
        ArrayList<Evento> activos = organizador.getEventosActivos();
        assertEquals(1, activos.size());
        assertEquals("ev5", activos.get(0).getId());
    }

    @Test
    public void testModificarEventoFisico() {
        organizador.crearEvento("ev6", "Expo", 4, LocalDateTime.now(), "Expo", "Recinto", "Bilbao", "Vizcaya");
        organizador.modificarEvento("ev6", "Expo Modificada", 5, LocalDateTime.now().plusDays(1), "Expo", "Nuevo Recinto", "Bilbao", "Vizcaya");
        Evento evento = organizador.getEventos().get(0);
        assertEquals("Expo Modificada", evento.getNombre());
        assertEquals(5, evento.getDuracion());
        assertTrue(evento instanceof Fisico);
        Fisico fisico = (Fisico) evento;
        assertEquals("Nuevo Recinto", fisico.getLugar());
    }

    @Test
    public void testModificarEventoOnline() {
        organizador.crearEvento("ev7", "Online Expo", 2, LocalDateTime.now(), "Expo", "www.expo.com");
        organizador.modificarEvento("ev7", "Online Expo Mod", 3, LocalDateTime.now().plusDays(2), "Expo", "www.nuevoexpo.com");
        Evento evento = organizador.getEventos().get(0);
        assertEquals("Online Expo Mod", evento.getNombre());
        assertEquals(3, evento.getDuracion());
        assertTrue(evento instanceof Online);
        Online online = (Online) evento;
        assertEquals("www.nuevoexpo.com", online.getSitioWeb());
    }
}
