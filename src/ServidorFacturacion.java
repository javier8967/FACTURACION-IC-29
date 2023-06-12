import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorFacturacion {
    public static void main(String[] args) {
        int puerto = 8888;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor en espera de conexiones...");

            Socket conexion = servidor.accept();
            System.out.println("Conexión establecida desde: " + conexion.getInetAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter salida = new PrintWriter(conexion.getOutputStream(), true);

            String data;
            while ((data = entrada.readLine()) != null) {
                String respuesta = procesarSolicitud(data);
                salida.println(respuesta);
            }

            conexion.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String procesarSolicitud(String data) {

        return "¡Factura generada correctamente Para el GRUPO IC 29!";
    }
}
