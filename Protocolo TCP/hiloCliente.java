import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hiloCliente extends Thread{
    private Socket socket_clientes;
    public hiloCliente(Socket socket_clientes) {
        this.socket_clientes = socket_clientes;
    }
    public void run() {
        // Crear buffers de entrada y salida de datos del cliente
        Scanner src = new Scanner(System.in);
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_clientes.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_clientes.getOutputStream(), true);

            // Leer datos del cliente
            String datos_recibidos = entrada.readLine();
            System.out.println("Datos recibidos del cliente: " + datos_recibidos);

            // Enviar datos al cliente
            // String mensaje = "Hola server";
            // salida.println(mensaje);
            String mensaje;
            System.out.print("Escribe un mensaje para el cliente: ");
            mensaje = src.nextLine();
            salida.println(mensaje);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
