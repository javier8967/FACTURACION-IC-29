import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteFacturacion {
    public static void main(String[] args) {
        String servidor = "localhost";
        int puerto = 8888;

        try (Socket cliente = new Socket(servidor, puerto)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            String solicitud = "Datos de la factura";
            salida.println(solicitud);

            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
