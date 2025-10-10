package org.example.veterinariajavafx.Model;


public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private String edad; // mantengo string para seguir el diagrama
    private String peso; // idem
    private String id;

    public Mascota(String nombre, String especie, String raza, String edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return nombre + " - " + especie + " / " + raza;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + getDescripcion();
    }

}