import com.murcia.utils.Input;
import com.murcia.utils.Menu;

public class Aereopuerto  {

    private Vuelo vuelo;
    private Pasajero pasajero;
    private Avion avion;

    public static void main(String[] args) {

        Aereopuerto a = new Aereopuerto();

        String[] opciones = {
            "1. Registrar vuelo",
            "2. Cambiar estado del vuelo",
            "3. Registrar pasajero",
            "4. Asignar pasajero al vuelo",
            "5. Enviar pasajero a cola",
            "6. Mostrar cola de abordaje",
            "7. Abordar pasajero",
            "8. Mostrar informacion del vuelo",
            "9. Salir"
        };

        //  CLAVE: usar 'V' para menu vertical real
        Menu menu = new Menu(opciones, 'V', "", "\nSISTEMA AEROPUERTO");

        char op;

        do {
            op = menu.select("Seleccione una opcion");

            System.out.println("\n----------------------------");

            switch (op) {

                case '1': {
                    System.out.println("REGISTRAR VUELO");

                    String numeroVuelo = Input.next("Codigo del vuelo: ");
                    String origen = Input.next("Origen: ");
                    String destino = Input.next("Destino: ");
                    String matricula = Input.next("Matricula del avion: ");

                    a.avion = new Avion("Boeing 737", 180, matricula);
                    a.vuelo = new Vuelo(numeroVuelo, origen, destino, a.avion);

                    System.out.println("Vuelo registrado");
                    break;
                }

                case '2': {
                    System.out.println("CAMBIAR ESTADO");

                    if (a.vuelo != null) {
                        String estado = Input.next("Nuevo estado: ");
                        a.vuelo.setEstado(estado);
                        System.out.println("Estado actualizado");
                    } else {
                        System.out.println("No hay vuelo");
                    }
                    break;
                }

                case '3': {
                    System.out.println("REGISTRAR PASAJERO");

                    String nombre = Input.next("Nombre: ");
                    String documento = Input.next("Documento: ");
                    String nacionalidad = Input.next("Nacionalidad: ");

                    a.pasajero = new Pasajero(nombre, documento, nacionalidad);

                    System.out.println("Pasajero registrado");
                    break;
                }

                case '4': {
                    System.out.println("ASIGNAR PASAJERO");

                    if (a.vuelo != null && a.pasajero != null) {
                        a.pasajero.asignarVuelo(a.vuelo);
                        a.vuelo.agregarPasajero(a.pasajero);
                        System.out.println("Pasajero asignado");
                    } else {
                        System.out.println("Falta vuelo o pasajero");
                    }
                    break;
                }

                case '5': {
                    System.out.println("ENVIAR A COLA");

                    if (a.vuelo != null && a.pasajero != null) {
                        a.vuelo.agregarACola(a.pasajero);
                        System.out.println("Pasajero en cola");
                    } else {
                        System.out.println("Falta vuelo o pasajero");
                    }
                    break;
                }

                case '6': {
                    System.out.println("COLA DE ABORDAJE");

                    if (a.vuelo != null) {
                        a.vuelo.mostrarCola();
                    } else {
                        System.out.println("No hay vuelo");
                    }
                    break;
                }

                case '7': {
                    System.out.println("ABORDAR PASAJERO");

                    if (a.vuelo != null) {
                        a.vuelo.abordarPasajero();
                    } else {
                        System.out.println("No hay vuelo");
                    }
                    break;
                }

                case '8': {
                    System.out.println("INFORMACION DEL VUELO");

                    if (a.vuelo != null) {
                        System.out.println(a.vuelo.mostrar());
                    } else {
                        System.out.println("No hay vuelo");
                    }
                    break;
                }

                case '9': {
                    System.out.println("Fin del sistema");
                    break;
                }

                default: {
                    System.out.println("Opcion invalida");
                }
            }

            if (op != '9') {
                Input.nextLine("Presione ENTER para continuar");
            }

        } while (op != '9');
    }
}
//TODO VA CON LISTAS ENLAZADAS
//los metodos a usar en la clase aereopuerto son los siguientes:
//registrar vuelo, modificar vuelo
//registrar pasajero, modificar pasajero
//asignar pasajero a vuelo
//ver estado de vuelo, ver estado de pasajero
//mostrar vuelos, mostrar pasajeros
        
    
    /**
 * Clase principal del sistema de gestion de aeropuerto.
 * 
 * Permite la interaccion con el usuario a traves de un menu en consola,
 * donde se pueden realizar operaciones como registrar vuelos, registrar
 * pasajeros, asignarlos y gestionar el abordaje.
 * 
 * Esta clase contiene el metodo main y coordina la ejecucion del sistema.
 */ /** Objeto que representa el vuelo actual del sistema */
/** Objeto que representa el pasajero actual */
/** Objeto que representa el avion asociado al vuelo */
/**
 * Metodo principal que inicia la ejecucion del programa.
 * 
 * Muestra el menu de opciones y permite al usuario interactuar
 * con el sistema mediante la seleccion de diferentes funcionalidades.
 * 
 * @param args argumentos de linea de comandos
 */

//comentario para hacer un nuevo comit - parcial
//comentario primera pregunta