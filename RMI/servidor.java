import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) {
        try {
            // Se crea el objeto remoto
            interfaz objeto = new implementacion();

            // Crer y obtner registro de RMI en le piertp especifico
            Registry registro = LocateRegistry.createRegistry(1234);

            // Vincula la implementacion remota al registro con nombre especifico
            registro.rebind("Cliente", objeto);

            // Se muestra un mensaje indicando que el servidor esta listo
            System.out.println("Servidor listo");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}