package Clases;

public class Receta {
    private int codigoCit;
    private String medicamentos;
    private String instrucciones;

    /*----------------------------------------Constructors--------------------------------------*/
    public Receta(){

    }
    public Receta(int codigoCit, String medicamentos, String instrucciones) {
        this.codigoCit = codigoCit;
        this.medicamentos = medicamentos;
        this.instrucciones = instrucciones;
    }

    /*----------------------------------------Getters and Setters--------------------------------------*/
    public int getCodigoCit() {
        return codigoCit;
    }

    public void setCodigoCit(int codigoCit) {
        this.codigoCit = codigoCit;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}
