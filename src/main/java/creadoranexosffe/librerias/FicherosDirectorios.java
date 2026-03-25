/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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

    public static String generarNombreFicheroAnexo1(String nombreAlumno, String ciclo, String modulo) {
        return nombreAlumno + "_" + ciclo + "_" + modulo + "_ANEXOI.pdf";
    }

    public static String generarNombreFicheroAnexo2(String nombreAlumno, String ciclo) {
        return nombreAlumno + "_" + ciclo + "_ANEXOII.pdf";
    }

    public static File obtenerRutaAplicacion() {
        try {
            return new File(
                    FicherosDirectorios.class
                            .getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
            ).getParentFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException("No se pudo determinar la ruta del ejecutable");
        }
    }
}
