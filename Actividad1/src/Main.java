import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Map<String, String> alumnos = new HashMap<>(); //SE DECLARA LA INSTANCIA MAP DENTRO LA VARIABLE ALUMNOS
        Scanner leer = new Scanner(System.in);
        String nombreAlumno;
        String carnetAlumno;
        String busquedaCarnet;
        String resultadoBusqueda;
        String resultadoEliminar;
        String eliminarCarnetAlumno;
        int opcion;
        boolean resultadoValidacionEntrada;

        while (true) { //SE REALIZA UN MENU CON UN BUCLE WHILE QUE SE REPETIRA SIEMPRE QUE SEA TRUE LA CONDICION

            System.out.println("\n Menú:");
            System.out.println("1. Ingresar Alumno");
            System.out.println("2. Busqueda de Alumno por carnet");
            System.out.println("3. Eliminar Alumno por carnet");
            System.out.println("4. Mostrar todos los Alumnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); //SE LIMPIA EL BUFFER

            switch (opcion) {
                case 1:
                    do {
                        System.out.print("Ingrese nombre completo del estudiante: ");
                        nombreAlumno = leer.nextLine().toUpperCase(); //EL METODO toUpperCase ES PARA CONVERTIR EL TEXTO A MAYUSCULA.
                        resultadoValidacionEntrada = validacionEntrada(nombreAlumno);

                        if (resultadoValidacionEntrada){
                            System.out.print("ERROR NO SE ACEPTAN CAMPOS VACIOS NI NUMEROS !! \n");
                        }
                    } while (resultadoValidacionEntrada);


                    System.out.print("Ingrese número de carnet del estudiante: ");
                    carnetAlumno = leer.nextLine().toUpperCase();

                    alumnos.put(carnetAlumno, nombreAlumno);
                    System.out.println("Estudiante registrado: " + nombreAlumno + " (carnet: " + carnetAlumno + ")");
                    break;
                case 2:
                    System.out.print("Ingrese número de carnet para buscar al estudiante: ");
                    busquedaCarnet = leer.nextLine().toUpperCase();
                    resultadoBusqueda = busquedaAlumno(alumnos, busquedaCarnet);
                    if (resultadoBusqueda != null) {
                        System.out.println("El estudiante con carnet " + busquedaCarnet + " es: " + resultadoBusqueda);
                    } else {
                        System.out.println("No se encontró información para el carnet " + busquedaCarnet);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese número de carnet para eliminar al estudiante: ");
                    eliminarCarnetAlumno = leer.nextLine().toUpperCase();
                    resultadoEliminar = alumnos.remove(eliminarCarnetAlumno);
                    if (resultadoEliminar != null) {

                        System.out.println("Se ha eliminado al estudiante " + resultadoEliminar + " con carnet " + eliminarCarnetAlumno);
                    } else {
                        System.out.println("No se encontró información para el carnet " + eliminarCarnetAlumno);
                    }
                    break;
                case 4:
                    System.out.println("Lista de Alumnos:");
                    for (String carnet : alumnos.keySet()) {
                        String alumno = alumnos.get(carnet);
                        System.out.println("Nombre: " + alumno + " - carnet: " + carnet);
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida, seleccione una opción valida.");
            }
        }
    }

    static String busquedaAlumno (Map<String, String> alumnos, String carnet) { //FUNCION PARA BUSCAR ALUMNO POR SU CARNET
        for (Map.Entry<String, String> alumno : alumnos.entrySet()) {

            if (alumno.getKey().equals(carnet)) { //SE REALIZA UNA COMPARACION CON EL CARNET
                return alumno.getValue(); //SI SE CUMPLE LA CONDICION RETORNA EL NOMBRE DEL ALUMNO
            }
        }
        return null; // SI NO SE CUMPLE RETORNA UN VALOR NULL
    }

    static  Boolean validacionEntrada(String texto) //FUNCION PARA VALIDAR ENTRADA DE TEXTO
    {
        if (texto.isEmpty()){
            return true;
        }
        else {
            for(char t : texto.toCharArray()){
                if (Character.isDigit(t)){
                    return true;
                }
            }
        }
        return false;
    }
}



