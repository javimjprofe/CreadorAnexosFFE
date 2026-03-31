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
import java.time.format.DateTimeFormatter;

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
                    FicherosDirectorios.generarNombreFicheroAnexoI(alumno, 
                                       datosComunes, 
                                       modulo);
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

             return true;
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean rellenarAnexoII(File directorioDestino, Alumno alumno, DatosComunes datosComunes) {
        try {

            // Cargar el archivo PDF
            InputStream ficheroOrigen = getClass().getResourceAsStream("/anexos/AnexoII.pdf");
            PdfReader reader = new PdfReader(ficheroOrigen);


            // Crear PdfStamper para editar el PDF
            String nombreFicheroDestino = 
                    FicherosDirectorios.generarNombreFicheroAnexoII(alumno, 
                                       datosComunes);
            PdfStamper stamper = new PdfStamper(reader, 
                    new FileOutputStream(directorioDestino.getAbsoluteFile() + "/" 
                            + datosComunes.getCodigoCiclo()+ "/" 
                            + nombreFicheroDestino));

            // Obtener el formulario del PDF
            AcroFields fields = stamper.getAcroFields();

            // Rellenar el campo "Alumno" con el valor que deseas
            fields.setField("Alumno", alumno.getNombre() + " " + alumno.getApellidos());
            
            //****Datos Comunes****
            fields.setField("Ciclo", datosComunes.getNombreCiclo());
            fields.setField("Grupo", datosComunes.getGrupo());
            fields.setField("AnioEscolar", datosComunes.getAnyoEscolarIni() + "/" + datosComunes.getAnyoEscolarFin());
            fields.setField("Curso", Integer.toString(datosComunes.getCurso()));
            fields.setField("En", datosComunes.getPoblacion());
            fields.setField("Dia", Integer.toString(datosComunes.getFechaFirma().getDayOfMonth()));
            fields.setField("Mes", mesALetra(datosComunes.getFechaFirma().getMonthValue()));
            fields.setField("Anio", Integer.toString(datosComunes.getFechaFirma().getYear()));
            fields.setField("FechaSesion", datosComunes.getFechaSesion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            // Cerrar el PdfStamper
            stamper.close();
            reader.close();
            return true;
          
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
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
