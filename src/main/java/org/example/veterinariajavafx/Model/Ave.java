package org.example.veterinariajavafx.Model;

public class Ave extends Mascota {
    private String tipoPlumaje;
    private boolean capacidadVuelo;
    private String cantidadAlimento; // cantidad/porcion a alimentar

    public Ave(String nombre, String especie, String raza, String edad, String peso, String id,
               String tipoPlumaje, boolean capacidadVuelo, String cantidadAlimento) {
        super(nombre, especie, raza, edad);
        this.tipoPlumaje = tipoPlumaje;
        this.capacidadVuelo = capacidadVuelo;
        this.cantidadAlimento = cantidadAlimento;
    }

    public String getTipoPlumaje() {

        return tipoPlumaje;
    }
    public void setTipoPlumaje(String tipoPlumaje) {

        this.tipoPlumaje = tipoPlumaje;
    }
    public boolean isCapacidadVuelo() {

        return capacidadVuelo;
    }
    public void setCapacidadVuelo(boolean capacidadVuelo) {

        this.capacidadVuelo = capacidadVuelo;
    }
    public String getCantidadAlimento()
    {
        return cantidadAlimento;
    }
    public void setCantidadAlimento(String cantidadAlimento) {

        this.cantidadAlimento = cantidadAlimento;
    }
    @Override
    public String toString() {
        return "Ave " + super.toString();
    }
}
