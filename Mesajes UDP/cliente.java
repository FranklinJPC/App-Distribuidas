import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class cliente {
    public static void main(String[] args) {
        try {
            int puerto = 5000; // Puerto
            // Socket UDP
            DatagramSocket socket = new DatagramSocket();

            // Direccion IP del servidor
            InetAddress direccion_servidor = InetAddress.getByName("localhost");
            
            // Mensaje a enviar
            String mensaje = "No soy el cliente .__...... creo";
            // Arreglo de bytes para enviar datos
            byte[] bufferSalida = mensaje.getBytes();
            
            // Crear paquete para enviar datos
            DatagramPacket paquete_enviar = new DatagramPacket(bufferSalida, 0, bufferSalida.length, direccion_servidor, puerto);

            // Recibe paquete 
            socket.send(paquete_enviar);

             // Arreglo de bytes para recibir datos
            byte[] bufferEntrada = new byte[1024];

            // Paquete para recibir datos
            DatagramPacket paquete_recibir = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);

            // Recibir paquete
            socket.receive(paquete_recibir);

            // Extraer la informacion del paquete recibido
            String mensajeRecibido = new String(paquete_recibir.getData());
            System.out.println("Mensaje: " + mensajeRecibido);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
