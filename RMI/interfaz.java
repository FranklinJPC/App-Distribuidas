import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends Remote {

    // Metodos que el cliente invocara
    // String saludo() throws RemoteException;
    double suma(double a, double b) throws RemoteException;
    double resta(double a, double b) throws RemoteException;
    double multiplicacion(double a, double b) throws RemoteException;
    double division(double a, double b) throws RemoteException;
}
