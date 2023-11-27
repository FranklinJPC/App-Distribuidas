import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class clienteTCP {
    public static void main(String[] args) {
        try {
            // Crear un socket para conectarse al servidor
            Socket socket_cliente = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor.....");
            // Crear buffers de entrada y salida de datos del cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            // Recibir datos al cliente
            String mensaje = "Hola al habla el cliente";
            salida.println(mensaje);

            // Leer datos del cliente
            String datos_recibidos = entrada.readLine();
            System.out.println("Datos recibidos del servidor: " + datos_recibidos);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
