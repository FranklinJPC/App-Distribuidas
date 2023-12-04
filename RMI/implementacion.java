import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacion extends UnicastRemoteObject implements interfaz {
    public implementacion() throws RemoteException {
        super();
    }

    // Implementacion de los metodos indicados en la interfaz
    // public String saludo() throws RemoteException {
    //     return "Hola mundo!";
    // }

    // Implementacion del metodo suma de la interfaz
    public double suma(double a, double b) throws RemoteException {
        return a + b;
    }
    public double resta(double a, double b) throws RemoteException {
        return a - b;
    }
    public double multiplicacion(double a, double b) throws RemoteException {
        return a * b;
    }
    public double division(double a, double b) throws RemoteException {
        return a / b;
    }
}