package org.example.veterinariajavafx.Model;

public class Perro extends Mascota {
    private String nivelAdiestrado;
    private String paseoDiario;
    private Tamano tamano;

    public Perro(String nombre, String especie, String raza, String edad, String peso, String id,
                 String nivelAdiestrado, String paseoDiario, Tamano tamano) {
        super(nombre, especie, raza, edad);
        this.nivelAdiestrado = nivelAdiestrado;
        this.paseoDiario = paseoDiario;
        this.tamano = tamano;
    }

    public String getNivelAdiestrado() {
        return nivelAdiestrado;
    }
    public void setNivelAdiestrado(String nivelAdiestrado) {
        this.nivelAdiestrado = nivelAdiestrado;
    }

    public String getPaseoDiario() {
        return paseoDiario;
    }
    public void setPaseoDiario(String paseoDiario) {
        this.paseoDiario = paseoDiario;
    }
    public Tamano getTamano() {
        return tamano;
    }
    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }
    @Override
    public String toString() {
        return "Perro " + super.toString();
    }
}
