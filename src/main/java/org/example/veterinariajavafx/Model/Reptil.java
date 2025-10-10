package org.example.veterinariajavafx.Model;

public class Reptil extends Mascota {
    private String temperaturaOptima;
    private TipoHabitat tipoHabitat;
    private Peligrosidad peligrosidad;

    public Reptil(String nombre, String especie, String raza, String edad, String peso, String id,
                  String temperaturaOptima, TipoHabitat tipoHabitat, Peligrosidad peligrosidad) {
        super(nombre, especie, raza, edad);
        this.temperaturaOptima = temperaturaOptima;
        this.tipoHabitat = tipoHabitat;
        this.peligrosidad = peligrosidad;
    }
    public String getTemperaturaOptima() {
        return temperaturaOptima;
    }
    public void setTemperaturaOptima(String temperaturaOptima) {
        this.temperaturaOptima = temperaturaOptima;
    }
    public TipoHabitat getTipoHabitat() {
        return tipoHabitat;
    }
    public void setTipoHabitat(TipoHabitat tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }
    public Peligrosidad getPeligrosidad() {
        return peligrosidad;
    }
    public void setPeligrosidad(Peligrosidad peligrosidad) {
        this.peligrosidad = peligrosidad;
    }
    @Override
    public String toString() {
        return "Reptil " + super.toString();
    }
}
