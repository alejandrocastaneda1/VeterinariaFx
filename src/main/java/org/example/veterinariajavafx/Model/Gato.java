package org.example.veterinariajavafx.Model;

public class Gato extends Mascota {
    private String suenoProm; // mantengo string según diagrama
    private String nivelIndependencia;

    public Gato(String nombre, String especie, String raza, String edad, String peso, String id,
                String suenoProm, String nivelIndependencia) {
        super(nombre, especie, raza, edad);
        this.suenoProm = suenoProm;
        this.nivelIndependencia = nivelIndependencia;
    }

    public String getSuenoProm() {
        return suenoProm;
    }
    public void setSuenoProm(String suenoProm) {
        this.suenoProm = suenoProm;
    }
    public String getNivelIndependencia() {
        return nivelIndependencia;
    }
    public void setNivelIndependencia(String nivelIndependencia) {
        this.nivelIndependencia = nivelIndependencia;
    }
    @Override
    public String toString() {
        return "Gato " + super.toString();
    }
}
