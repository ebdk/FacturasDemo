README.md

# Proyecto Maven echo con Spring.

# Idea de la App: 

Una demo de creador de Facturas basado en un servicio de arreglo de autos.

El usuario (empleado) debe primero ingresar el nombre del cliente con los datos del vehiclo.

Si el cliente no existe, saltara error y uno debe ,en otro boton, registrar al cliente.

Una vez creada la factura esta aparecera en la lista de facturas.

Al entrar, uno debe ir ingresando que partes fueron usadas dentro de la lista TOTAL de partes disponibles en el sistema
(ESTOS YA DEBEN ESTAR INGRESADOS EN LA BBDD PREVIAMENTE; Sus campos son: idRepuesto, descripcion, costo y urlImg).

Una vez ingresado cantidad de partes y horas tardadas en instalarlas, esta se agrega al "Carrito" (SessionAttribute) que 
este recordara los datos aun si se cierra el browser.

Al terminar de elegir las partes en el carrito, se apreta el boton de "Agregar a Facturas" donde ya se guardara en la factura
siendo editada en el momento (el carrito es provisorio, y este se vacia al agregar sus partes en la factura).



# Especificaciones: use mysql para la BBDD, por ende esta configurado de esta manera

spring.datasource.url = jdbc:mysql://localhost:3307/facturas?useSSL=false

spring.datasource.username = root

spring.datasource.password = 1234

# Para empezar el proyecto, correr PostsApplicatin.java en un interprete de Java y abrir un navegador web en "localhost:8080"

# Creado por Esteban Bedecarats en el transcurso de un curso de Java.