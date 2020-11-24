# Enunciado
/*Nos solicitan desarrollar un programa que permita gestionar las reservas de los asientos en un vuelo.
Del ​ Vuelo ​ conocemos los siguientes atributos: número de vuelo (String), cantidad total de asientos
que posee, la lista de asientos reservados y el monto total recaudado, que en un inicio será 0.
En cuanto al ​ Asiento​ , sabemos que tiene un pasajero (de tipo Pasajero), una clase (Enumerado, de
valores PRIMERA, BUSINESS, TURISTA), un precio, ​ su fila (string) y su número (int) (que indican la
ubicación en el avión). Respecto de las ubicaciones las filas van de la A hasta la T y en cada fila los
asientos se numeran del 1 hasta el 6, sin que haya un pasillo que los separe.
Aclaración: para que sea más práctico, la nomenclatura de asientos de nuestro avión es al revés de
los aviones verdaderos: filas con letras y columnas con número.
En este momento especial que atraviesa la sociedad las aerolíneas toman medidas de cuidado.
Una de ellas es que entre cada pasajero debe haber un asiento intermedio libre.
El ​ Pasajero cuenta con los siguientes atributos: DNI y teléfono. Ambos enteros. Los datos de un
pasajero no pueden estar asignados a más de un asiento.
Se nos pide crear lo siguiente en donde corresponda:
● Constructor de Vuelo: Recibe el número de vuelo y la cantidad de asientos. El monto
recaudado en un inicio debe ser 0.
● Método privado ​ buscarAsientoReservado​ (): Recibe una fila y un número de asiento y, en
el caso de existir en la lista de asientos reservados, retorna el asiento correspondiente. De lo
contrario retorna NULL.
● Método privado verDistanciamiento(): Recibe una fila y un número de asiento y debe verificar
que los asientos que están a la izquierda y a la derecha del que está en la ubicación recibida
no estén reservados. (Ayudita: hay que chequear en la misma fila, y una columna anterior
Taller de Herramientas de Programación - Parcial 2
1Instituto de Tecnología ORT
Carrera de Analista de Sistemas
Materia: TALLER DE HERRAMIENTAS DE PROGRAMACIÓN
EXAMEN PARCIAL 2
●
para ver el de la izquierda, y una columna posterior para ver el asiento que está a la derecha.
Tené en cuenta que a la izquierda de la columna 1 no hay asiento, y a la derecha de la
columna 6 tampoco)
Método público ​ reservarAsiento​ (): Dados DNI, teléfono, clase, fila y letra, reservar asiento
agregándolo a la lista y teniendo en cuenta la actualización del monto total recaudado.
Observación: si se cumple alguno de los siguientes casos, el asiento no se agregará a la lista,
retornando el respectivo estado con un enumerado ​ ResultadoReservaBoletos ​ que refleje
estas posibilidades:
○ “Error avión completo”.
○
○
“Error ya tiene un pasaje”.
“Error el asiento de al lado está ocupado” (para cada asiento debe
verificarse que el asiento de al lado de la misma fila no esté ocupado).
En el caso exitoso, es decir, cuando no se cumpla alguna de estas dos condiciones devolver
un valor que signifique “Reserva confirmada”.
●
●
Método privado ​ obtenerAcumuladoPorClase​ (): ​ Recibe la clase y, en caso de haber,
retorna el monto acumulado de los asientos reservados para la misma
Método público ​ mostrarMontoRecaudadoDeClase​ (): ​ Recibe la clase y muestra los
siguientes mensajes según corresponda:
El monto acumulado hasta el momento en la clase _________ es: $ _____
No hay asientos reservados para clase ________
No hay asientos reservados en ninguna clase
●
Método privado ​ setPrecioSegunClase​ ​ en la clase Asiento: setea el precio según la clase
(turista, business o primera) teniendo en cuenta que en caso de ser de clase Turista, el precio
es de $50.000, Business $100.000 y Primera $150.000.
Implementar los getters y setters necesarios y el método toString de cada una de las clases.
