import java.util.Map;
import java.util.HashMap;

public class Foro1 {
    public static void main(String[] args) {
        HashMap<String, Integer> personaEdad = new HashMap<String, Integer>(); // INSTANCIA DE LA CLASE HashMap

        personaEdad.put("Juan", 28);
        personaEdad.put("Karlita", 30); //AGREGAR DATOS AL MAP
        personaEdad.put("Odir", 55);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("********************IMPRIMIMOS EL LISTADO INICIAL********************");
        for (Map.Entry <String, Integer> p : personaEdad.entrySet() ){
            System.out.println("NOMBRE: " + p.getKey() + " EDAD: " + p.getValue()); //IMPRESION DEL MAP
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("********************ELIMINAMOS LA CLAVE CON EL NOMBRE ODIR********************");
        personaEdad.remove("Odir"); //ELIMINAMOS LA YAVE ODIR CON EL VALOR 55
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("***************************IMPRIMIMOS EL LISTADO FINAL***************************");
        for (Map.Entry <String, Integer> p : personaEdad.entrySet() ){
            System.out.println("NOMBRE: " + p.getKey() + " EDAD: " + p.getValue()); //IMPRESION DEL MAP
        }
    }
}
