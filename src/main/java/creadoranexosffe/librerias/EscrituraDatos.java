/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creadoranexosffe.librerias;
import java.io.File;
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
      public boolean rellenarAnexoI(File directorioDestino, Alumno alumno, Modulo modulo, DatosComunes datosComunes) {
        try {

            // Cargar el archivo PDF
            InputStream ficheroOrigen = getClass().getResourceAsStream("/anexos/AnexoI.pdf");
            PdfReader reader = new PdfReader(ficheroOrigen);
            
            // Crear PdfStamper para editar el PDF
            String nombreFicheroDestino = 
                    FicherosDirectorios.generarNombreFicheroAnexo1(alumno, 
                                       datosComunes.getNombreCiclo(), 
                                       modulo.getNombre());
            PdfStamper stamper = new PdfStamper(reader, 
                    new FileOutputStream(directorioDestino.getAbsoluteFile() + "/" 
                            + datosComunes.getCodigoCiclo()+ "/" 
                            + modulo.getCodigo() + "/" +  nombreFicheroDestino));

            // Obtener el formulario del PDF
            AcroFields fields = stamper.getAcroFields();

            // Rellenar el campo "Alumno" 
            fields.setField("Alumno", alumno.getNombre() + " " + alumno.getApellidos());

            //Datos Módulo
            fields.setField("Modulo", modulo.getNombre());

            //****Datos Comunes****
            fields.setField("Ciclo", datosComunes.getNombreCiclo());
            fields.setField("Grupo", datosComunes.getGrupo());
            fields.setField("AnioEscolar", datosComunes.getAnyoEscolarIni() + "/" + datosComunes.getAnyoEscolarFin());
            fields.setField("Curso", Integer.toString(datosComunes.getCurso()));
            fields.setField("En", datosComunes.getPoblacion());
            fields.setField("Dia", Integer.toString(datosComunes.getFechaFirma().getDayOfMonth()));
            fields.setField("Mes", mesALetra(datosComunes.getFechaFirma().getMonthValue()));
            fields.setField("Anio", Integer.toString(datosComunes.getFechaFirma().getYear()));

            // Cerrar el PdfStamper
            stamper.close();
            reader.close();

            System.out.println("Formulario PDF relleno con éxito.");
            return true;
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
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
    
    private String mesALetra(int numMes){
        switch (numMes){
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "";
        }
    }
}
