/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;

import java.time.LocalDate;

/**
 *
 * @author javimjprofe
 */
public class DatosComunes {
    private String codigoCiclo;
    private String nombreCiclo;
    private int curso;
    private int anyoEscolarIni;
    private int anyoEscolarFin;
    private String grupo;
    private String poblacion;
    private LocalDate fechaSesion;
    private LocalDate fechaFirma;

    public DatosComunes(String codigoCiclo, String nombreCiclo, int curso, 
            int anyoEscolarIni, int anyoEscolarFin, String grupo, 
            String poblacion, LocalDate fechaSesion, LocalDate fechaFirma) {
        this.codigoCiclo = codigoCiclo;
        this.nombreCiclo = nombreCiclo;
        this.curso = curso;
        this.anyoEscolarIni = anyoEscolarIni;
        this.anyoEscolarFin = anyoEscolarFin;
        this.grupo = grupo;
        this.poblacion = poblacion;
        this.fechaSesion = fechaSesion;
        this.fechaFirma = fechaFirma;
    }

    public String getCodigoCiclo() {
        return codigoCiclo;
    }

    public void setCodigoCiclo(String codigoCiclo) {
        this.codigoCiclo = codigoCiclo;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAnyoEscolarIni() {
        return anyoEscolarIni;
    }

    public void setAnyoEscolarIni(int anyoEscolarIni) {
        this.anyoEscolarIni = anyoEscolarIni;
    }

    public int getAnyoEscolarFin() {
        return anyoEscolarFin;
    }

    public void setAnyoEscolarFin(int anyoEscolarFin) {
        this.anyoEscolarFin = anyoEscolarFin;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public LocalDate getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(LocalDate fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public LocalDate getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(LocalDate fechaFirma) {
        this.fechaFirma = fechaFirma;
    }
    
}
