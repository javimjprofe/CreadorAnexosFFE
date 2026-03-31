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

    public static String generarNombreFicheroAnexoI(Alumno alumno, DatosComunes datosComunes, Modulo modulo) {
        return alumno.getApellidos().replace(" ","_") + "_" + alumno.getNombre()
                + "_" + datosComunes.getCodigoCiclo() + "_" + modulo.getCodigo() + "_ANEXOI.pdf";
    }

    public static String generarNombreFicheroAnexoII(Alumno alumno, DatosComunes datosComunes) {
        return alumno.getApellidos().replace(" ","_") + "_" + alumno.getNombre()
                + "_" + datosComunes.getCodigoCiclo() + "_ANEXOII.pdf";
    }
}
