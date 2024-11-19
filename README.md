# Peluquería Canina App

## Descripción

La **Peluquería Canina App** es una aplicación de escritorio diseñada para gestionar la información de una peluquería canina. Este sistema permite registrar, listar, modificar y eliminar datos relacionados con los clientes (dueños de las mascotas) y las mascotas atendidas en la peluquería.

La aplicación está desarrollada exclusivamente en **Java**, utilizando **JPA** para la persistencia de datos y **Swing** para la interfaz gráfica.

---

## Funcionalidades

### Registro de datos
- Permite agregar información detallada de:
  - **Mascotas**: nombre, raza, color, observaciones, etc.
  - **Dueños**: nombre y número de contacto.

### Gestión de datos
- **Listado**: Visualiza una lista completa de los clientes y sus mascotas.
- **Modificación**: Actualiza los datos de las mascotas y sus dueños de forma sencilla.
- **Eliminación**: Elimina registros de clientes o mascotas según sea necesario.

### Detalles adicionales
- Incluye opciones para indicar si una mascota es alérgica o necesita atención especial.
- Interfaz gráfica amigable y funcional para facilitar la interacción con los usuarios.

---

## Tecnologías utilizadas

- **Java**: Lenguaje principal para el desarrollo de la aplicación.
- **Swing**: Framework para la creación de la interfaz gráfica.
- **JPA (Java Persistence API)**: Para la gestión y persistencia de los datos en la base de datos.

---

## Requisitos del sistema

1. **Java JDK**: Versión 8 o superior.
2. **Base de datos**: Configurada para ser compatible con JPA (por ejemplo, MySQL o PostgreSQL).
3. **IDE recomendado**: Eclipse, IntelliJ IDEA o NetBeans.
4. **Bibliotecas necesarias**: Asegúrate de tener configuradas las dependencias de JPA.

---

## Instalación y configuración

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/usuario/peluqueria-canina-app.git
   ```
2. **Configurar la base de datos**:
   - Crear una base de datos en tu gestor preferido.
   - Actualizar los detalles de conexión en el archivo de configuración de persistencia (`persistence.xml`).

3. **Ejecutar la aplicación**:
   - Importar el proyecto en tu IDE.
   - Compilar y ejecutar desde la clase principal.
---

### Pantalla Principal
Muestra el menú principal con las opciones disponibles.  
![Pantalla Principal](https://i.ibb.co/gd8FRgb/Principal.png)

### Formulario de Registro
Formulario para agregar datos de mascotas y sus dueños.  
![Formulario de Registro](https://i.ibb.co/JQNmMjL/Cargar-Datos.png)

### Listado de Registros
Vista de los registros existentes con opciones para modificar o eliminar.  
![Listado de Registros](https://i.ibb.co/Lr5XYMt/Listado-Datos.png)

