import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorTCP {
    public static void main(String[] args) {
        // Crear Socket del servidor
        try {
            ServerSocket socket_servidor = new ServerSocket(5000);

            while (true) 
            {
                // Esperar y aceptar las conexiones de clientes
                Socket socket_clientes = socket_servidor.accept();
                System.out.println("Cliente conectado: " + socket_clientes.getInetAddress().getHostAddress());

                // Hilo para manejar la conexion con el cliente
                hiloCliente hilo = new hiloCliente(socket_clientes);
                hilo.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}