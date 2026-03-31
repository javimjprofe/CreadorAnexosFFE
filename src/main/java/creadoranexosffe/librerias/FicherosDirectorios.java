/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author javimjprofe
 */
public class FicherosDirectorios {

    public static String crearCarpeta(String ruta) {
        Path carpeta = Path.of(ruta);

        if (!Files.exists(carpeta)) {
            try {
                // Crear la carpeta (y las carpetas intermedias si no existen)
                Files.createDirectories(carpeta);
                System.out.println("Carpeta creada con éxito.");
            } catch (IOException e) {
                System.err.println("Error al crear la carpeta: " + e.getMessage());
                return "";
            }
        }
        return ruta;
    }

    public static String generarNombreFicheroAnexo1(Alumno alumno, String ciclo, String modulo) {
        return alumno.getNombre() + "_" + alumno.getApellidos().replace(" ","_") 
                + "_" + ciclo + "_" + modulo + "_ANEXOI.pdf";
    }

    public static String generarNombreFicheroAnexo2(Alumno alumno, String ciclo) {
        return alumno.getNombre() + "_" + alumno.getApellidos().replace(" ","_")
                + "_" + ciclo + "_ANEXOII.pdf";
    }
}
