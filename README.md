# Cartelera
Listado de Peliculas y Series
<p>Consumo de Web Service REST https://api.themoviedb.org/3/ para el listado de cartelera de Cine y Series, imagenes e informacion individual.</p>

## Características.
<li>Muestra peliculas </li>
<li>Muestra Series </li>
<li>Identifica mediante diferentes tamaños de imagenes las mas vistas</li>
<li>La seccion de peliculas puede ser personalizado facilmente incluyendo la categoria general a mostrar como Top, Latest, etc.</li>
<li>Muestra un detalle sencillo de peliculas o serie</li>
<li>Utiliza un cache de imagenes </li>

## Configuración
La Clase  Constans contiene la mayor parte de parametros que pueden personalizarse para el consumo de la api.

<br>
Librerias
<li>Retrofit.</li>
<li>OkHttp.</li>
<li>Picasso</li>

## Vistas/Capa Presentacion
El sistema cuenta con 4 vistas principales:
<br>
Despues de analizar a detalle la API se decidio implementar dos vistas, la Principal MainActivity y Detail para mostrarla informacion de la selección.
Las secciones se generar de forma dinamica mediante la generacion de fragmentos, cada fragmento controla el tipo de series y/o peliculas que mostrara y la atención al detalle

La seccion de Consultas/Busquedas, se puede implementar de varias formar, una de las mas senccillas es crear una actividad y observar los cambios de texto en un EditText con la finalidad de lanzar consultar a la api y mostar los resultados en un RecyclerView con formto GRID.
La otra forma es usar el widget de Search para generar un vista y lanzar la consultas a la api, ya sea directamenta o mediante un proveedor de contenido, esto tambien se puede implementar en un layout sobrepuesto a la actividad.

#Mejoras

## Pruebas Unitarias
Debido al tamaño de la estructura de la app, y por la poca interaccion del usuario, considero que la pruebas Unitarias de Intrumentacion se pueden enfocar a usar Expresso para validar el flujo de cambio de actividad principal y detalle, y generar la serie de pasos para validar esos cambios.

Referente a las pruebas funcionales, podemos evaluar el resultado de una funcion, o un observable, en su momento evaluar el resultado de una funcion o metodo. aqui se me ocurre poder evaluar los metodos anexos al modelo que se implementaron.

## Inyeccion de Dependencias
Utilizar Dagger para la inyeccion de dependencias en la construccion de los Viewmodels o la instanciacion de clases dependientes.

# Mejoras en Usabilidad
<li>Presentar mensajes de alertas cuando el usuario no tenga acceso a internet</li>
<li>Implementar el Refres mediante el pull del scroll</li>
<li>Atender el evento de cambio de network o conexion para ejecutar un refres automatico en caso de no haber cargado informacion </li>
<li>Un Onboarding para configuracion de preferencias/idioma/pais</li>
<li>Mejorar la presentacion de la vista del Detalle</li>


----------------------

# Autor
<p>Martin Sarabia Aquino - 31 Mayo 2021</p>

