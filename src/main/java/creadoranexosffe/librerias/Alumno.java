/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;

/**
 *
 * @author javimjprofe
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    
    public Alumno(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApelllidos(String apellidos){
        this.apellidos = apellidos;
    }
    
}
