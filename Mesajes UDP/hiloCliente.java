import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class hiloCliente extends Thread{
    private DatagramSocket socket;
    private DatagramPacket paquete;

    // Contructor 
    public hiloCliente(DatagramSocket socket, DatagramPacket paquete)
    {
        this.socket = socket;
        this.paquete = paquete;
    }

    public void run()
    {
        Scanner scr = new Scanner(System.in);
        try {
            // Extraer info del paquete recibido
            String mensajeRecibido = new String(paquete.getData());
            System.out.println("Mensaje Cliente: " + mensajeRecibido);

            // Obtner direccion del cliente 
            InetAddress direccion_cliente = paquete.getAddress();
            int puerto_cliente = paquete.getPort();

            // Mensaje de respuesta 
            
            String respuesta;
            System.out.print("Mensaje Server: ");
            respuesta = scr.nextLine();

            // Arreglo de bytes para enviar datos
            // byte[] bufferSalida = new byte[1024];
            byte[] bufferSalida = respuesta.getBytes();
            DatagramPacket paquete_respuesta = new DatagramPacket(bufferSalida, 0, bufferSalida.length, direccion_cliente, puerto_cliente);

            // Enviar Datagrama
            socket.send(paquete_respuesta);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
