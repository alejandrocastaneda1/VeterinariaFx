package org.example.veterinariajavafx.Model;

public class Consulta {
    private String numId;
    private String fecha;   // mantengo String (puedes usar LocalDate si prefieres)
    private String animalId; // id de la mascota o nombre
    private float valorBase;
    private float costoFinal;
    private TipoConsulta tipoConsulta;

    public Consulta(String numId, String fecha, String animalId, float valorBase, float costoFinal) {
        this.numId = numId;
        this.fecha = fecha;
        this.animalId = animalId;
        this.valorBase = valorBase;
        this.costoFinal = costoFinal;
    }


    public String getNumId() {
        return numId;
    }
    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAnimalId() {
        return animalId;
    }
    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public float getValorBase() {
        return valorBase;
    }
    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }
    public float getCostoFinal() {
        return costoFinal;
    }
    public void setCostoFinal(float costoFinal) {
        this.costoFinal = costoFinal;
    }
    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }
    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    @Override
    public String toString() {
        return "Consulta[" + numId + "] " + tipoConsulta + " - " + fecha;
    }

    public double calcularCosto() {
        return 0;
    }
}
