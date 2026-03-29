/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package creadoranexosffe;

import java.util.List;
import java.util.Scanner;
import creadoranexosffe.librerias.*;

/**
 *
 * @author javimjprofe
 */
public class CreadorAnexosFFE {

    public static void main(String[] args) {
//        List<String[]> alumnos;
//        List<String[]> datosModulos;
//        List<String> datosComunes;
//        String rutaFicheroOrigen;
//        String rutaFicheroDestino;
//        RecopilacionDatos recopilacionDatos = new RecopilacionDatos();
//        EscrituraDatos escrituraDatos = new EscrituraDatos();
//        int eleccion;
//        Scanner scanner = new Scanner(System.in);
//        String rutaDestino;
//
//        do {
//            System.out.println("Dime que tipo de fichero quieres copiar: ");
//            System.out.println("1.- Anexo I");
//            System.out.println("2.- Anexo II");
//            System.out.print("Tu elección es: ");
//            eleccion = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println();
//        } while (eleccion != 1 && eleccion != 2);
//
//        alumnos = recopilacionDatos.recopilarAlumnos();
//        datosModulos = recopilacionDatos.recopilarDatosModulos();
//        datosComunes = recopilacionDatos.recopilarDatosComunes();
//
//        if (eleccion == 1) {
//            for (String[] nombreAlumno : alumnos) {
//                for (String[] modulo : datosModulos) {
//                    rutaDestino = FicherosDirectorios.crearCarpeta("./" + datosComunes.get(0) + "_" + modulo[0]);
//                    if (rutaDestino.isEmpty()) {
//                        return;
//                    }
//                    rutaFicheroDestino = rutaDestino + "/" + FicherosDirectorios.generarNombreFicheroAnexo1(nombreAlumno[1].replace(" ", "_") + "_" + nombreAlumno[0], datosComunes.get(0), modulo[0]);
//                    escrituraDatos.rellenarAnexoI(rutaFicheroDestino, nombreAlumno[0] + " " + nombreAlumno[1], modulo, datosComunes);
//                }
//            }
//        } else {
//            for (String[] nombreAlumno : alumnos) {
//                rutaDestino = FicherosDirectorios.crearCarpeta("./" + datosComunes.get(0));
//                if (rutaDestino.isEmpty()) {
//                    return;
//                }
//                rutaFicheroOrigen = "./anexos/AnexoII.pdf";
//                rutaFicheroDestino = rutaDestino + "/" + FicherosDirectorios.generarNombreFicheroAnexo2(nombreAlumno[1].replace(" ", "_") + "_" + nombreAlumno[0], datosComunes.get(0));
//                escrituraDatos.rellenarAnexoII(rutaFicheroDestino, nombreAlumno[0] + " " + nombreAlumno[1], datosComunes);
//            }
//        }
   }

}
