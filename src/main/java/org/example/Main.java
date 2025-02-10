package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lowagie.text.pdf.*;
import com.lowagie.text.DocumentException;


public class Main {
    public static void main(String[] args) {
        List<String[]> alumnos;
        List<String[]> datosModulos;
        List<String> datosComunes;
        String rutaFicheroOrigen;
        String rutaFicheroDestino;
        int eleccion;
        Scanner scanner = new Scanner(System.in);
        String rutaDestino;

        do {
            System.out.println("Dime que tipo de fichero quieres copiar: ");
            System.out.println("1.- Anexo I");
            System.out.println("2.- Anexo II");
            System.out.print("Tu elección es: ");
            eleccion = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
        } while (eleccion != 1 && eleccion != 2);

        alumnos = recopilarAlumnos();
        datosModulos = recopilarDatosModulos();
        datosComunes = recopilarDatosComunes();

        if (eleccion == 1) {
            for (String[] nombreAlumno : alumnos) {
                for (String[] modulo : datosModulos) {
                    rutaDestino = crearCarpeta("./" + datosComunes.get(0) + "_" + modulo[0]);
                    if (rutaDestino.isEmpty())
                        return;
                    rutaFicheroOrigen = "./AnexoI.pdf";
                    rutaFicheroDestino = rutaDestino + "/" + generarNombreFicheroAnexo1(nombreAlumno[1].replace(" ", "_") + "_" + nombreAlumno[0], datosComunes.get(0), modulo[0]);
                    rellenarAnexoI(rutaFicheroOrigen, rutaFicheroDestino, nombreAlumno[0] + " " + nombreAlumno[1], modulo, datosComunes);
                }
            }
        } else {
            for (String[] nombreAlumno : alumnos) {
                rutaDestino = crearCarpeta("./" + datosComunes.get(0));
                if (rutaDestino.isEmpty())
                    return;
                rutaFicheroOrigen = "./AnexoII.pdf";
                rutaFicheroDestino = rutaDestino + "/" + generarNombreFicheroAnexo2(nombreAlumno[1].replace(" ", "_") + "_" + nombreAlumno[0], datosComunes.get(0));
                rellenarAnexoII(rutaFicheroOrigen, rutaFicheroDestino, nombreAlumno[0] + " " + nombreAlumno[1], datosComunes);
            }
        }
    }

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

    public static List<String[]> recopilarAlumnos() {
        Scanner scanner;
        String linea;
        File file;
        List<String[]> alumnos = new ArrayList<>();

        try {
            file = new File("./alumnos.csv");
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
            file = new File("./modulos.csv");
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
            file = new File("./datosComunes.txt");
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

    public static String generarNombreFicheroAnexo1(String nombreAlumno, String ciclo, String modulo) {
        return nombreAlumno + "_" + ciclo + "_" + modulo + "_ANEXOI.pdf";
    }

    public static String generarNombreFicheroAnexo2(String nombreAlumno, String ciclo) {
        return nombreAlumno + "_" + ciclo + "_ANEXOII.pdf";
    }

    public static void copiarFichero(String ficheroOrigen, String ficheroDestino) {
        // Especificar la ruta del archivo origen y destino
        Path origen = Path.of(ficheroOrigen);
        Path destino = Path.of(ficheroDestino);

        try {
            // Copiar el archivo
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado con éxito.");

        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }
    }


    public static void rellenarAnexoI(String nombreFicheroOrigen, String nombreFicheroDestino, String nombreAlumno, String[] modulo, List<String> datosComunes) {
        try {

            // Cargar el archivo PDF
            PdfReader reader = new PdfReader(nombreFicheroOrigen);


            // Crear PdfStamper para editar el PDF
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(nombreFicheroDestino));

            // Obtener el formulario del PDF
            AcroFields fields = stamper.getAcroFields();

            // Rellenar el campo "Alumno" con el valor que deseas
            fields.setField("Alumno", nombreAlumno);

            //Datos Módulo
            fields.setField("Modulo", modulo[1]);

            //****Datos Comunes****
            //Ciclo
            //Grupo
            //AnioEscolar
            //Curso
            //En
            //Dia
            //Mes
            //Anio
            fields.setField("Ciclo", datosComunes.get(1));
            fields.setField("Grupo", datosComunes.get(2));
            fields.setField("AnioEscolar", datosComunes.get(3));
            fields.setField("Curso", datosComunes.get(4));
            fields.setField("En", datosComunes.get(5));
            fields.setField("Dia", datosComunes.get(6));
            fields.setField("Mes", datosComunes.get(7));
            fields.setField("Anio", datosComunes.get(8));


            // Cerrar el PdfStamper
            stamper.close();
            reader.close();

            System.out.println("Formulario PDF relleno con éxito.");
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void rellenarAnexoII(String nombreFicheroOrigen, String nombreFicheroDestino, String nombreAlumno, List<String> datosComunes) {
        try {

            // Cargar el archivo PDF
            PdfReader reader = new PdfReader(nombreFicheroOrigen);


            // Crear PdfStamper para editar el PDF
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(nombreFicheroDestino));

            // Obtener el formulario del PDF
            AcroFields fields = stamper.getAcroFields();

            // Rellenar el campo "Alumno" con el valor que deseas
            fields.setField("Alumno", nombreAlumno);

            //Datos Comunes
            //Ciclo
            //Grupo
            //AnioEscolar
            //Curso
            //En
            //Dia
            //Mes
            //Anio
            fields.setField("Ciclo", datosComunes.get(1));
            fields.setField("Grupo", datosComunes.get(2));
            fields.setField("AnioEscolar", datosComunes.get(3));
            fields.setField("Curso", datosComunes.get(4));
            fields.setField("En", datosComunes.get(5));
            fields.setField("Dia", datosComunes.get(6));
            fields.setField("Mes", datosComunes.get(7));
            fields.setField("Anio", datosComunes.get(8));
            fields.setField("FechaSesion", datosComunes.get(9));


            // Cerrar el PdfStamper
            stamper.close();
            reader.close();

            System.out.println("Formulario PDF relleno con éxito.");
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}

