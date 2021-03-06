# HistorialEquiposCVDS

**Nombre del curso:** Ciclos de Vida del Desarrollo De Software
 
**Integrantes:**

  * Javier Esteban López
  * Yarit Yajanny Villalobos 
  * András Felipe Dávila
  * Miguel Ángel Fúquene

**Profesores:**

  * Julian Mauricio Velasco
  * Óscar David Ospina

**Roles asignados:**

  * **Julian Mauricio Velasco:** Dueño de producto 
  * **Javier Esteban López:** Desarrollador
  * **Yarit Yajanny Villalobos:** Desarrollador
  * **Andrés Felipe Dávila:** Desarrollador
  * **Miguel Ángel Fúquene:** Desarrollador primi
  
### Descripción del proyecto

  * **Descripcion General:**  
    
  * **Manual de Usuario:**
    
    El inicio de sesión, donde el usuario es el correo electronico
    
    ![](resources/inicioSesion.JPG)
    
    Se abrira un menu donde se encuentran 4 opciones
    
    ![](resources/menu.JPG)
    
      - **Equipos:** Aqui se puede consultar y registrar equipos, además se puede asociar equipos a los laboratorios.    
      - **Elementos:** Aqui se puede consultar y registrar elementos, además se puede asociar elementos a equipos.  
      - **Novedades:** Aqui esta el historial de todas las novedades de cada elemento, equipo y laboratorio
      - **Laboratorios:** Aqui se puede consultar y registrar laboratorios.
  # Equipos:
Para poder registrar un equipo se tienen que llenar los campos, y darle en el boton registrar equipo.
![](resources/registrarEquipo.JPG)

En la tabla van a estar unicamente los equipos que estan activos y se podra ordenar por Id, Nombre, equipos Activos y por nombre de Laboratorios, Cada color en la tabla tiene el significado de disponibilidad.(verde->Equipos disponibles y no estan asignados a un laboratorios, amarillos -> Equipos activos y estan asignados a un laboratorio, rojos -> Equipos dados de baja), al dar en la pestaña "Todos los Equipos" se veran los equivos activos y desactivos, se pueden seleccionar varios equipos y en la parte superior derecha de la tabla se verá una caneca, donde indica que va a dar de baja estos equipos.
Debajo de la tabla estara el botón de descargar, donde se podra descargar la tabla presente.

![](resources/tablaEquipo.JPG)

Al frente de cada fila de equipo, se podra ver un link "Ver Equipo", que los llevara a la información del equipo y tambien estará la opción para registrar una nueva novedad.

![](resources/novedadEquipo.JPG)

En la primera tabla se podrá ver las novedades de ese equipo, ordenadas de la más reciente a la mas antigua. Debajo de la tabla estara el botón de descargar, donde se podra descargar la tabla presente.

![](resources/equipoNovedad.JPG)

  # Elementos:
  Para poder registrar un elemento se tienen que llenar los campos, y darle en el boton registrar elemento.
  
  ![](resources/registrarElemento.JPG)
  
En la tabla se encontraran todos los elementos y se pdran ordenar por Id,Tipo,Nombre,Dado de baja,Equipo asociado. Cada color en la tabla tiene el significado de disponibilidad.(verde->Elementos disponibles y no estan asignados a un equipo, amarillos -> Elementos activos y estan asignados a un equipo, rojos -> Elementos dados de baja), se pueden seleccionar varios elementos y en la parte superior derecha de la tabla se verá una caneca, donde indica que va a dar de baja estos eelementos.
Debajo de la tabla estara el botón de descargar, donde se podra descargar la tabla presente.
 
![](resources/tablaElemento.JPG)

Al frente de cada fila de elemento, se podra ver un link "Ver Elemento", que los llevara a la información del elemento y tambien estará la opción para registrar una nueva novedad de ese elemento.

![](resources/verElemento.JPG)
  
 En la primera tabla se podrá ver las novedades de ese elemento, ordenadas de la más reciente a la mas antigua. Debajo de la tabla estara el botón de descargar, donde se podra descargar la tabla presente.
 
 ![](resources/elementoNovedad.JPG)
 
 En la segunda tabla se podra asociar elementos a equipos, el elemento que estaba en uso por el equipo seleccionado quedará disponible para uso y será remplazado por el respectivo elemento.
 
  ![](resources/asociarElemento.JPG)
 
  # Novedades:
  Aquí se podrá ver todas las novedades de todos los elementos,quipos y laboratorios. Estaran ordenas de la mas reciente a la mas antigua.
  
  ![](resources/novedades.JPG)
  
  # Laboratorios:
  Pantalla de laboratorios
  
  ![](resources/pagina.PNG)
  
  A la hora de ingresar a los laboratorios nos permite la opción de registrar ingresando el nombre y el departamento 
  
  ![](resources/registrar.PNG)
  
  Podemos encontrar en la columnas un boton *Cerrar Laboratorio*, donde al interactuar y aceptar el cuadro cerrará el laboratorio marcandolo con un color rojo que significa que el laboratorio se encuentra cerrado. Aclarar que si el laboratorio cuenta con equipos, estos de desasociarán de los laboratorios cerrados
  
  ![](resources/cerrado.PNG)
  
  El otro boton que encontramos en la columnas es *Equipos Asociados*, que al interactuar nos enviará a una nueva pantalla donde veremos la información de los equipos que estan asociados a este laboratorio
  
  ![](resources/equipos.PNG)
  
  Además de ello se podrán asociar los equipos a los laboratorios, selecciona los equipos que desea asociar y le da en asociar que se encuentra en la parte superior derecha
  
  ![](resources/asociar.JPG)
  
  Como una opción añadida se pueden descargar los laboratorios como archivo .xls para visualizarla en una hoja de calculo y tenerla guardado en archivos locales
  
  ![](resources/download.PNG)
  
### Arquitectura y Diseño Detallado

  * **Modelo E-R:**
  
    ![](resources/diagrama.JPG)
    
    
  * **Diagrama de clases:**
  * **Descripción de la arquitectura y el Stack de tecnologías utilizado:
 
   * [PrimeFaces (Framework)](https://www.primefaces.org/)
   * [Guice (Inyección de Dependencias)](https://github.com/google/guice)
   * PostgreSQL (DataBase Management)
   * [MyBatis (Framework)](https://mybatis.org/mybatis-3/es/)
  * **Enlace a la aplicacion en Heroku:** https://historialequipos.herokuapp.com/faces/Autenticacion.xhtml
      
  * **Enlace al sistema de integración continua https://app.circleci.com/pipelines/github/ProdigiousECI/HistorialEquiposCVDS
### Descripción del proceso:

  * **Integrantes:
   >|     Nombre    |     Rol         |
   >|--------------|------------- |
   >|Miguel Fuquene	|Developer  | 
   >|Yarit  Villalobos|Developer   |
   >|Javier Lopez|Developer   |
   >|Andres Davila|Developer   |
  * **Breve Descripción de Metodoloía:
   Se utilizó la metodología **Scrum**,  el grupo de trabajo se reunió para planear cada uno de los sprints los cuales se dividieron en 3 en acuerdo con el cliente, para mejorar    la interacción con el cliente se le presento de acuerdo al tiempo establecido para cada sprint las debidas entregas.
   después de la revisión del cliente se procede a hacer la restrospectiva del sprint entregado y la planeación del siguiente hasta la entrega final.
  * **Enlace a Taiga:** https://tree.taiga.io/project/javier200151-historial-de-equipos-labinfo-1/backlog?milestone=276704
  * **Release-burndown chart y puntos de historias realizadas y faltantes:
  ## Detalles por sprint
### Sprint 1
**Sprint-burndown chart**\
![](https://github.com/ProdigiousECI/HistorialEquiposCVDS/blob/master/resources/sprint%201%20backlog.PNG)

##### Resumen del sprint 1
Durante el inicio del proyecto, hubi difcultades en cuanto a comunicacion y coordinacion de los detalles de como iba a ser la metodologia de trabajo dado a las condiciones de ultima instancia. esto nos retraso un poco en cuanto a la entrega se logro el objetivo en  cuanto al sprint 1.

**Sprint 1  backlog**\
![](https://github.com/ProdigiousECI/HistorialEquiposCVDS/blob/master/resources/sprint%201.PNG)
### Sprint 2
**Sprint-burndown chart**\
![](https://github.com/ProdigiousECI/HistorialEquiposCVDS/blob/master/resources/sprint%202%20backlog.PNG)
##### Resumen del sprint 2
Para este Sprint comenzamos ya de forma adecuada, unas tareas sin actualizar a tiempo en el taiga, por eso el cambio, ya para este momento nos reunimos a final de cada sprint para la integracion de las funcionalidades de acuerdo a las asignaciones con el fin de que cada integrante trabajara de forma adecuada y en conjunto. en este sprint incluimos las correcciones del sprint 1.
**Sprint 2  backlog**\
![](https://github.com/ProdigiousECI/HistorialEquiposCVDS/blob/master/resources/sprint%202.PNG)
### Sprint3
**Sprint-burndown chart**\
![](https://github.com/ProdigiousECI/HistorialEquiposCVDS/blob/master/resources/sprint%203%20backlog.PNG)
##### Resumen del sprint 3
Comenzamos el sprint de forma adecuada con un poco de tiempo, por esto logramos empatar los puntos en algunas fechas, el equipo sin excepcion trabajo en sus funcionalidades y las correcciones generales. para este punto el proyecto se desarrollo de acuerdo a la metodologia planeada sin inconvinientes
**Sprint 3 backlog ** \
![](https://github.com/ProdigiousECI/HistorialEquiposCVDS/blob/master/resources/sprint%203.PNG)
  * **Pruebas:**
  * **Reporte de Analisis estático de código**


### Circle CI

[![ProdigiousECI](https://circleci.com/gh/ProdigiousECI/HistorialEquiposCVDS.svg?style=svg)](https://app.circleci.com/pipelines/github/ProdigiousECI/HistorialEquiposCVDS)





