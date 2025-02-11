# Configuración
El proyecto cuenta con tres ficheros desde los que extrae la información necesaria:
1. **alumnos.csv** donde se almacenarán en cada línea dos campos referentes a los alumnos. Ambos separados por el caracter ";"
  - Nombre
  - Apellidos
2. **modulos.csv** donde se almacenrán en cada línea los datos de los módulos sobre los que necesitamos que se creen los ficheros pdf. Consta de dos campos separados por el caracter ";"
  - Código del módulo
  - Nombre del módulo
3. **datosComunes.txt** donde se almacenarán datos comunes tanto para el Anexo I, como para el Anexo II. Cada línea corresponde a un dato
  - Código del ciclo
  - Nombre del ciclo
  - Grupo
  - Año escolar
  - Curso
  - Población
  - Día de firma
  - Mes de firma
  - Año año de firma
  - Fecha de la sesión de evaluación (Formado dd/mm/yyyy)


# Durante la ejecución
El programa solicitará que se elija entre las dos posibles opciones mediante un menú
1. Anexo I
2. Anexo II


# Resultado de la ejecución

Para el **Anexo I** se creará una carpeta cuyo nombre sea la unión del código del ciclo y del módulo, y dentro se almacenrá un fichero por cada alumno.

Para el **Anexo II** se creará una carpeta cuyo nombre sea el código del ciclo, y dentro se almacenrá un fichero por cada alumno.


# Descargar y ejecutar el programa
- Descargar solo el fichero CreadorAnexosFFE.zip desde este link <https://github.com/javimjprofe/CreadorAnexosFFE/blob/main/CreadorAnexosFFE.zip> (Pulsar el botón con los tres puntos y seleccionar "Download")
- Necesitas tener instalada al menos la versión 19 de Java en tu ordenador. Si no lo tienes te recomiendo que descargues e instales la versión 21 desde esta página <https://www.oracle.com/java/technologies/downloads/#jdk21-windows>
- Descomprime el fichero en una carpteta
- Configuralos los tres ficheros anteriormente nombrados con tus necesidades
- Abre la consola de comandos en la carpeta que se encuentre el fichero CreadorAnexosFFE.jar
- Ejecuta el siguiente comando "java -jar CreadorAnexosFFE.jar"
