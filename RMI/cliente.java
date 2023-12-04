import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import javax.swing.plaf.synth.Region;

public class cliente {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Se obtiene el registro en el puerto especifico
            Registry registro = LocateRegistry.getRegistry("localhost", 1234);

            // Crear instancia de la implementcion de la interfaz remota
            interfaz objeto = (interfaz) registro.lookup("Cliente");

            // Se invoca el metodo remoto
            // System.out.println(objeto.saludo());
            // System.out.println(objeto.suma(5, 15));
            System.out.println("----- Calculadora -----");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el primer numero: ");
                    double a = sc.nextDouble();
                    System.out.print("Ingrese el segundo numero: ");
                    double b = sc.nextDouble();
                    System.out.println("Resultado: " + objeto.suma(a, b));
                    break;
                case 2:
                    System.out.print("Ingrese el primer numero: ");
                    a = sc.nextDouble();
                    System.out.print("Ingrese el segundo numero: ");
                    b = sc.nextDouble();
                    System.out.println("Resultado: " + objeto.resta(a, b));
                    break;
                case 3:
                    System.out.print("Ingrese el primer numero: ");
                    a = sc.nextDouble();
                    System.out.print("Ingrese el segundo numero: ");
                    b = sc.nextDouble();
                    System.out.println("Resultado: " + objeto.multiplicacion(a, b));
                    break;
                case 4:
                    System.out.print("Ingrese el primer numero: ");
                    a = sc.nextDouble();
                    System.out.print("Ingrese el segundo numero: ");
                    b = sc.nextDouble();
                    System.out.println("Resultado: " + objeto.division(a, b));
                    break;
                default:
                    System.out.println("Opcion incorrecta...");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}