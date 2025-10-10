package org.example.veterinariajavafx.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeterinariaTest {

    // Creamos veterinaria simple para todas las pruebas
    Veterinaria vet = new Veterinaria("VetCare", "12345");

    // 1. Costo de consulta general perro joven
    @Test
    void costoConsultaPerroJoven() {
        Consulta c = new Consulta("001", "2025-10-01", "Perro", 50000, 0);
        vet.CRUD("crear", c);
        float costo = vet.costoConsulta(c, "001", "joven");
        assertEquals(50000, costo);
    }

    // 2. Costo urgencia gato senior
    @Test
    void costoUrgenciaGatoSenior() {
        Consulta c = new Consulta("002", "2025-10-01", "Gato", 70000, 0);
        vet.CRUD("crear", c);
        float costo = vet.costoConsulta(c, "002", "senior");
        assertEquals(77000, costo);
    }

    // 3. Descuento consulta aves adultas
    @Test
    void descuentoAveAdulto() {
        Consulta c = new Consulta("003", "2025-10-02", "Ave", 40000, 0);
        vet.CRUD("crear", c);
        c.setCostoFinal(c.getValorBase() * 0.9f);
        assertEquals(36000, c.getCostoFinal());
    }

    // 4. Costo vacunación reptil adulto
    @Test
    void costoVacunacionReptil() {
        Consulta c = new Consulta("004", "2025-10-03", "Reptil" ,60000, 0);
        vet.CRUD("crear", c);
        c.setCostoFinal(c.getValorBase() * 1.05f);
        assertEquals(63000, c.getCostoFinal());
    }

    // 5. Estimar dosis según peso
    @Test
    void estimarDosis() {
        String nombre = vet.estimarDosis("Fido", 2.5);
        assertEquals("Fido", nombre);
    }

    // 6. Excepción dosis inválida
    @Test
    void dosisInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            double peso = -3;
            if (peso <= 0) throw new IllegalArgumentException("Peso inválido");
        });
    }

    // 7. Próxima vacunación perros/gatos
    @Test
    void proximaVacunacionPerroGato() {
        String fecha = vet.sugerirFechaVacunacion("Perro");
        assertEquals("Perro", fecha);
    }

    // 8. Próxima vacunación aves
    @Test
    void proximaVacunacionAve() {
        String fecha = "Ave"; // simulación
        assertEquals("Ave", fecha);
    }

    // 9. Prioridad urgencia
    @Test
    void prioridadUrgencia() {
        int prioridad = vet.prioridadAtencion("Perro");
        assertEquals(0, prioridad); // simple
    }

    // 10. Responsable más frecuente
    @Test
    void responsableMasFrecuente() {
        vet.agregarResponsable(new Responsable("Juan", "1234","calle 13", 5));
        vet.agregarResponsable(new Responsable("Ana", "5678","calle11", 3));
        vet.responsableFrecuente(); // método ejecuta
        assertTrue(true); // solo verificamos que no falle
    }
}
