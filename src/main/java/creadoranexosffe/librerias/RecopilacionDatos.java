/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author javimjprofe
 */
public class RecopilacionDatos {
    public List<String[]> recopilarAlumnos() {
        Scanner scanner;
        String linea;
        InputStream file;
        List<String[]> alumnos = new ArrayList<>();

        try {
            file = getClass().getResourceAsStream("/modelos/alumnos.csv");
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

    public List<String[]> recopilarDatosModulos() {
        Scanner scanner;
        String linea;
        List<String[]> datos = new ArrayList<>();
        InputStream file;

        try {
            file = getClass().getResourceAsStream("/modelos/modulos.csv");
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

    public List<String> recopilarDatosComunes() {
        Scanner scanner;
        String linea;
        List<String> datos = new ArrayList<>();
        InputStream file;
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
            file = getClass().getResourceAsStream("/modelos/datosComunes.txt");
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
