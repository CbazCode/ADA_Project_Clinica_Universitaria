package Clases;

public class Medico {
    private int dniMedico;
    private String nombreMedico;
    private String apellidoPaternoMedico;
    private String apellidoMaternoMedico;
    private int telefonoMedico;
    private String correoElectronicoMedico;
    private String centroDeEstudioMedico;
    private String especialidadMedico;

    /*--------------------------------------------Constructors----------------------------------------*/
    public Medico(){

    }
    public Medico(int dniMedico, String nombreMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, int telefonoMedico, String correoElectronicoMedico, String centroDeEstudioMedico, String especialidadMedico) {
        this.dniMedico = dniMedico;
        this.nombreMedico = nombreMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.telefonoMedico = telefonoMedico;
        this.correoElectronicoMedico = correoElectronicoMedico;
        this.centroDeEstudioMedico = centroDeEstudioMedico;
        this.especialidadMedico = especialidadMedico;
    }

    /*----------------------------------------Getters and Setters--------------------------------------*/
    public int getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(int dniMedico) {
        this.dniMedico = dniMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidoPaternoMedico() {
        return apellidoPaternoMedico;
    }

    public void setApellidoPaternoMedico(String apellidoPaternoMedico) {
        this.apellidoPaternoMedico = apellidoPaternoMedico;
    }

    public String getApellidoMaternoMedico() {
        return apellidoMaternoMedico;
    }

    public void setApellidoMaternoMedico(String apellidoMaternoMedico) {
        this.apellidoMaternoMedico = apellidoMaternoMedico;
    }

    public int getTelefonoMedico() {
        return telefonoMedico;
    }

    public void setTelefonoMedico(int telefonoMedico) {
        this.telefonoMedico = telefonoMedico;
    }

    public String getCorreoElectronicoMedico() {
        return correoElectronicoMedico;
    }

    public void setCorreoElectronicoMedico(String correoElectronicoMedico) {
        this.correoElectronicoMedico = correoElectronicoMedico;
    }

    public String getCentroDeEstudioMedico() {
        return centroDeEstudioMedico;
    }

    public void setCentroDeEstudioMedico(String centroDeEstudioMedico) {
        this.centroDeEstudioMedico = centroDeEstudioMedico;
    }

    public String getEspecialidadMedico() {
        return especialidadMedico;
    }

    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }
}
