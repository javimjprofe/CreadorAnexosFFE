/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author javimjprofe
 */
public class RecopilacionDatos {
  
    public static List<String[]> recopilarAlumnos() {
        Scanner scanner;
        String linea;
        File file;
        List<String[]> alumnos = new ArrayList<>();

        try {
            file = new File("./datos/alumnos.csv");
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                linea = scanner.nextLine();
                if (linea.trim().isEmpty())
                    break;
                String[] lineaDividida = linea.split(";");
                //Nombre;Apellidos
                alumnos.add(lineaDividida);
            }
            scanner.close();
            return alumnos;
        } catch (Exception e) {
            System.out.println("Error al recopilar alumnos: " + e.toString());
            return new ArrayList<>();
        }
    }

    public static List<String[]> recopilarDatosModulos() {
        Scanner scanner;
        String linea;
        List<String[]> datos = new ArrayList<>();
        File file;

        try {
            file = new File("./datos/modulos.csv");
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                linea = scanner.nextLine();
                if (linea.trim().isEmpty())
                    break;
                datos.add(linea.split(";"));
                //Codigo;Nombre
            }
            scanner.close();
            return datos;
        } catch (Exception e) {
            System.out.println("Error al recopilar datos del módulo: " + e.toString());
            return new ArrayList<>();
        }
    }

    public static List<String> recopilarDatosComunes() {
        Scanner scanner;
        String linea;
        List<String> datos = new ArrayList<>();
        File file;
        //****Datos Comunes****
        //CodigoCiclo
        //Ciclo
        //Grupo
        //AnioEscolar
        //Curso
        //En
        //Dia
        //Mes
        //Anio
        //FechaSesion

        try {
            file = new File("./datos/datosComunes.txt");
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                linea = scanner.nextLine();
                if (linea.trim().isEmpty())
                    break;
                datos.add(linea);
            }
            scanner.close();
            return datos;
        } catch (Exception e) {
            System.out.println("Error al recopilar datos del módulo: " + e.toString());
            return new ArrayList<>();
        }
    }
}
