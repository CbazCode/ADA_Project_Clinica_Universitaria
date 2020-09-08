package Clases;


public class Consulta {
    private int codigoHist;
    private String signos;
    private String sintomas;
    private String resultados;
    private String diagnostico;
    /*----------------------------------------Constructors--------------------------------------*/
    public Consulta(){

    }
    public Consulta(int codigoHist, String signos, String sintomas, String resultados, String diagnostico) {
        this.codigoHist = codigoHist;
        this.signos = signos;
        this.sintomas = sintomas;
        this.resultados = resultados;
        this.diagnostico = diagnostico;
    }

    /*----------------------------------------Getters and Setters--------------------------------------*/
    public int getCodigoHist() {
        return codigoHist;
    }

    public void setCodigoHist(int codigoHist) {
        this.codigoHist = codigoHist;
    }

    public String getSignos() {
        return signos;
    }

    public void setSignos(String signos) {
        this.signos = signos;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
