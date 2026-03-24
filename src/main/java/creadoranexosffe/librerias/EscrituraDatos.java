/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;
import org.openpdf.text.DocumentException;
import org.openpdf.text.pdf.AcroFields;
import org.openpdf.text.pdf.PdfReader;
import org.openpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 *
 * @author javimjprofe
 */
public class EscrituraDatos {
      public void rellenarAnexoI(String nombreFicheroDestino, String nombreAlumno, String[] modulo, List<String> datosComunes) {
        try {

            // Cargar el archivo PDF
            InputStream ficheroOrigen = getClass().getResourceAsStream("/anexos/AnexoI.pdf");
            PdfReader reader = new PdfReader(ficheroOrigen);


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

    public void rellenarAnexoII(String nombreFicheroDestino, String nombreAlumno, List<String> datosComunes) {
        try {

            // Cargar el archivo PDF
            InputStream ficheroOrigen = getClass().getResourceAsStream("/anexos/AnexoII.pdf");
            PdfReader reader = new PdfReader(ficheroOrigen);


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
