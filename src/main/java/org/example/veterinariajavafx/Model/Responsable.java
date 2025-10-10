package org.example.veterinariajavafx.Model;
import java.util.Objects;

public class Responsable {
    private String nombre;
    private String contacto;
    private String direccion;
    private int nivelFidelidad;

    public Responsable(String nombre, String contacto, String direccion, int nivelFidelidad) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.nivelFidelidad = nivelFidelidad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return null;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivelFidelidad() {
        return nivelFidelidad;
    }
    public void setNivelFidelidad(int nivelFidelidad) {
        this.nivelFidelidad = nivelFidelidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + contacto + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Responsable)) return false;
        Responsable that = (Responsable) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(contacto, that.contacto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, contacto);
    }

}
