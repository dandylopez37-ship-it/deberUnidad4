# Sistema de Gestión de Contenidos Audiovisuales

Sistema Java para gestionar contenidos audiovisuales con arquitectura MVC, persistencia en archivos CSV y pruebas unitarias.

## Descripción

Aplicación que gestiona películas, series de TV y documentales aplicando principios SOLID y patrones de diseño MVC.

## Características

- Arquitectura MVC
- Persistencia en archivos CSV
- Operaciones CRUD completas
- Búsqueda por título y género
- Gestión de actores, temporadas e investigadores
- Pruebas unitarias con JUnit 5
- Principios SOLID aplicados

## Estructura del Proyecto

```
src/
├── poo/
│   ├── AplicacionMVC.java           # Aplicación principal MVC
│   └── PruebaAudioVisual.java       # Demo básica
└── uni1a/
    ├── ContenidoAudiovisual.java    # Clase abstracta base
    ├── Pelicula.java                # Películas con actores
    ├── SerieDeTV.java               # Series con temporadas
    ├── Documental.java              # Documentales con investigadores
    ├── Actor.java                   # Información de actores
    ├── Temporada.java               # Temporadas de series
    ├── Investigador.java            # Investigadores de documentales
    ├── controlador/
    │   └── ControladorContenido.java
    ├── modelo/
    │   └── CatalogoContenido.java
    ├── servicio/
    │   ├── IArchivable.java
    │   └── ContenidoAudiovisualCSV.java
    └── vista/
        └── VistaConsola.java

test/
└── uni1a/
    ├── PeliculaTest.java
    ├── SerieDeTVTest.java
    ├── DocumentalTest.java
    ├── ActorTest.java
    ├── TemporadaTest.java
    ├── InvestigadorTest.java
    └── modelo/
        └── CatalogoContenidoTest.java
```

## Principios SOLID Aplicados

- **SRP**: Cada clase tiene una responsabilidad única
- **OCP**: Extensible mediante herencia sin modificar código base
- **LSP**: Las subclases sustituyen a la clase base correctamente
- **ISP**: Interfaz `IArchivable` específica para persistencia
- **DIP**: Dependencia en abstracciones (interfaces)

## Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/CS-Programacion-Orientada-Objetos/poo_unidad1.git
cd poo_unidad1
```

2. Importar en Eclipse:
   - File → Import → Git → Projects from Git
   - Seleccionar "Existing local repository"
   - Añadir JUnit 5 al build path

3. Ejecutar aplicación MVC:
```bash
java poo.AplicacionMVC
```

## Uso del Sistema

La aplicación ofrece menú interactivo con opciones:

1. **Agregar contenido**: Crear películas, series o documentales
2. **Listar contenidos**: Ver todos los elementos del catálogo
3. **Buscar por título**: Búsqueda parcial de contenidos
4. **Buscar por género**: Filtrar por categoría
5. **Eliminar contenido**: Remover elementos del catálogo
6. **Guardar en archivo**: Persistir datos en CSV
7. **Cargar desde archivo**: Recuperar datos guardados

## Formato CSV

Los datos se guardan en `contenidos.csv` con formato:
```
tipo,id,titulo,duracion,genero,dato_especifico,datos_extra
PELICULA,0,Avatar,162,Ciencia Ficcion,20th Century,actor1|nacionalidad|edad;
SERIE,1,Breaking Bad,45,Drama,5,1|10|2008;2|13|2009;
DOCUMENTAL,2,Cosmos,45,Ciencia,Astronomia,Neil Tyson|Astrofisica|NASA
```

## Ejecución de Pruebas

Las pruebas unitarias cubren:
- Clases de dominio (Pelicula, Serie, Documental)
- Clases auxiliares (Actor, Temporada, Investigador)
- Modelo de negocio (CatalogoContenido)

### Ejecutar desde línea de comandos:
```bash
# Compilar
javac -d bin -sourcepath src src/uni1a/*.java src/uni1a/*/*.java src/poo/*.java

# Ejecutar aplicación demo
java -cp bin poo.PruebaAudioVisual

# Ejecutar prueba CSV
java -cp bin poo.PruebaCSV

# Ejecutar pruebas unitarias
java -jar lib/junit-platform-console-standalone-1.10.1.jar --class-path bin --scan-class-path
```

### Resultados de Pruebas
- 40 pruebas unitarias - Todas pasaron
- Sistema de archivos CSV funcionando correctamente
- Aplicación MVC completamente operativa

## Requisitos

- Java JDK 8 o superior
- JUnit 5 (Jupiter) - incluido en `lib/`
- Eclipse IDE o IntelliJ IDEA (opcional)

## Autor

Universidad Politécnica Salesiana - Programación Orientada a Objetos
