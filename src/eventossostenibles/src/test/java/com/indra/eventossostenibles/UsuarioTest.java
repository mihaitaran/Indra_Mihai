package com.indra.eventossostenibles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Usuario usuario;
    private Evento eventoFisico;
    private Evento eventoOnline;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("u1", "Ana Lopez", "ana@email.com", "pass123");
        eventoFisico = new Fisico("e1", "Feria Eco", 2, java.time.LocalDateTime.now(), "Feria", "Centro", "Madrid", "Madrid");
        eventoOnline = new Online("e2", "Webinar Sostenible", 1, java.time.LocalDateTime.now(), "Webinar", "www.webinar.com");
    }

    @Test
    public void testInscribirEvento() {
        usuario.inscribirEvento(eventoFisico);
        assertTrue(usuario.getEventos().contains(eventoFisico));
        // Inscribir dos veces no debe duplicar
        usuario.inscribirEvento(eventoFisico);
        assertEquals(1, usuario.getEventos().size());
    }

    @Test
    public void testCancelarInscripcion() {
        usuario.inscribirEvento(eventoOnline);
        usuario.cancelarInscripcion(eventoOnline);
        assertFalse(usuario.getEventos().contains(eventoOnline));
        // Cancelar dos veces no debe lanzar error
        usuario.cancelarInscripcion(eventoOnline);
    }

    @Test
    public void testFiltrarEventos() {
        ArrayList<Evento> lista = new ArrayList<>();
        lista.add(eventoFisico);
        lista.add(eventoOnline);
        usuario.filtrarEventos(lista, "Webinar");
        assertEquals(1, usuario.getEventos().size());
        assertEquals("e2", usuario.getEventos().get(0).getId());
    }

    @Test
    public void testToString() {
        String str = usuario.toString();
        assertTrue(str.contains("Ana Lopez"));
        assertTrue(str.contains("u1"));
        assertTrue(str.contains("ana@email.com"));
    }
}
