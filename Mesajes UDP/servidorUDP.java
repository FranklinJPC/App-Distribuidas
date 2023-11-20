import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
import java.net.DatagramPacket;

public class servidorUDP{
    public static void main(String[] args) {
        try {
            int puerto = 5000; // Puerto
            // Socket UDP
            DatagramSocket socket;
            socket = new DatagramSocket(puerto);
            System.out.println("Espera de conexion.....");

            while (true)
            {
                // Arreglo de bytes para recibir datos
                byte[] bufferEntrada = new byte[1024];
                // 
                DatagramPacket paquete = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);

                // Recibe paquete 
                socket.receive(paquete);
                Thread hilo_cliente = new hiloCliente(socket, paquete);
                hilo_cliente.start();
            }
            
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}