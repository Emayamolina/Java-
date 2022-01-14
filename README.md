# Netflix- applet in java 
Java project dedicated to imitating the rental of Netflix accounts. 

Spanish version 
Netflix ha decidido contratarlo para que realice un sistema informático que le permita gestionar la
lista de las diferentes cuentas de sus usuarios. Para cada cuenta, se requiere almacenar la siguiente
información: código, titular, contraseña, tipo (básico, plus o premium) y estado (activo, suspendido
e inactivo). Dependiendo del tipo de cuenta se requiere almacenar en una cola con la información
de los perfiles

De cada perfil se debe almacenar: el nombre, el idioma, la configuración por edad y una pila con el
nombre de la películas, series o documental que haya visto desde la última hasta la primera (pila).
Además de la información de los clientes, se requiere tener la lista con la información de las
reproducciones disponibles. De cada reproducción se debe tener: tipo (película, serie, otro), titulo,
genero, duración y año.

      Tipo de cuenta Cantidad de perfiles
      Básico 2
      Plus 3
      Premium 4

El sistema a desarrollar debe permitir:
  1. Registrar reproducción: se piden todos los datos la reproducción y se almacenan por orden
  de año.
  2. Registrar cuenta: para ello se solicita la identificación de la cuenta, se crea la cola (sin datos),
  el estado se inicializa en activo y se almacena en la lista doble esta información (Toda esta
  información debe estar en un único nodo de la lista)
  3. Registrar perfil: se debe solicitarle al usuario el código de usuario y la contraseña. Si esta
  información es correcta, se le solicita los datos del perfil a crear, validando según la cuenta
  que tenga perfiles disponibles. Se debe crear la pila de reproducciones (inicialmente vacía)
  para el perfil y almacenarlo en la cola correspondiente.
  4. Ver reproducción. Se debe validar el usuario y la contraseña. Luego se valida el estado de la
  cuenta, si es activa, el usuario debe seleccionar el perfil correspondiente. Para dicho usuario
  se debe presentar la información de todas las reproducciones disponibles para que él
  seleccione una. La información de la reproducción seleccionada se debe llevar a la pila del
  perfil correspondiente. Si la cuenta esta inactiva o suspendida, se debe mostrar un mensaje
  invitando al cliente reactivar la cuenta o realizar el pago.
  5. Cuenta de cobro: Se debe generar un archivo de texto para cada cuenta con la siguiente
  información: 

    Señor XXX:
    Usted ha disfrutado X películas, Y series y W otras
    reproducciones.
    No olvide realizar su pago por valor de $ ABC pesos.

Donde XXX, corresponde al titular de la cuenta, X el número de películas vista en todos los
perfiles de la cuenta, Y el número de películas vista en todos los perfiles de la cuenta, W
número de otros y ABC el valor del plan según el tipo básico: 21900, avanzado: 31900 y
premium: 38900)
  6. Top 10: se debe mostrar toda la información de las 10 reproducciones mas vista. (tener en
  cuenta lo visto en cada perfil).
  7. Realizar sorteo. Construir un árbol terciario (de forma aleatoria) con la información de los
  usuarios que tienen las cuentas suspendidas e inactivas. Para los usuarios que quedaron
  como hojas del árbol, cambiar el estado de estos a activos. Mostrar los titulares y códigos
  de las cuentas que resultaron ganadoras.
  8. Eliminar perfil. Se valida el usuario y la contraseña. El usuario debe seleccionar el perfil que
  se desea eliminar y se borra de la cola.
  9. Actualizar estado de cuenta. Se debe generar un método aleatorio para determinar el
  estado de cada una de las cuentas.
  10. Otras
    a. Determinar el listado de cuentas suspendidas y/o inactivas.
    b. Porcentaje de cuentas según su tipo.
    c. Total del dinero recaudado por las cuentas que están activas.
    d. Mostrar los usuarios que tienen perfiles disponibles y la cantidad de perfiles
    disponibles.
    e. Para una cuenta determinada, determinar el uso de cada perfil así: 

      Uso Cantidad de reproducciones
      Bajo Menor o igual a 10
      Medio Entre 11 y 50
      Alto Mayor a 50

