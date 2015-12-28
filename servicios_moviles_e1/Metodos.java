package servicios_moviles_e1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author José Luis Cabeza Díaz
 */
public class Metodos {

    ServerSocket s1;
    Socket s2;
    DataOutputStream enviar;
    DataInputStream recivir;
    int n1, n2, er = 0;
    Mensajes mensaje, mensaje2;
    final int PUERTO = 7000;
    final String user = "usr usuario";
    final String pass = "pas 1234";
    final String comando1 = "opera", comando2 = "opera2";
    String t, com;

    /**
     * Comprueba la validez de la clave y el usuario introducidos.
     *
     * @return Devuelve 'sesion', el cual vale true si el usuario y la clave son
     * correctos y false en caso contrario.
     */
    public boolean inicioSesion() {

        boolean sesion = false;
        try {

            String user1 = recivir.readLine();
            System.out.println(user1);

            String pass1 = recivir.readLine();
            System.out.println(pass1);

            if (user1.equals(user) && pass1.equals(pass)) {
                sesion = true;
            } else {
                sesion = false;
            }
        } catch (Exception ex) {
            System.out.print("Error: " + ex.getMessage());

        }
        return sesion;
    }

    /**
     * Si el resultado de la comprobación de las credenciales (inicioSesion();)
     * de usuario es true, obtiene los dos números enteros del usuario y
     * mediante las funciones de las clases Datos y Mensajes, ejecuta las
     * operaciones con los números segun el comando indicado (opera u opera2) y
     * devuelve una respuesta al cliente. En caso de que la comprobación sea
     * false, vuelve a ejecutarse esta función volviendo a pedir credenciales al
     * usuario.
     */
    public void servicio() {
        try {
            boolean in = inicioSesion();
            if (in == true) {
                System.out.println("\r\nAutenticacion aceptada.\r\n");
                enviar.writeUTF("\r\nAutenticacion aceptada.\r\n");
                enviar.writeUTF("\r\nEsperando comando...\r\n");
                do {
                    

                    t = recivir.readLine();
                    Scanner scan = new Scanner(t);
                    com = scan.next();
                    n1 = scan.nextInt();
                    n2 = scan.nextInt();
                    System.out.println(com);
                    
                    if (com.equals(comando1)) {

                        System.out.println(n1);
                        System.out.println(n2);

                        Datos dat = new Datos(n1, n2);
                        Datos res = dat.operaciones(dat);
                        Mensajes m = new Mensajes();
                        mensaje = m.texto(dat, res);//Hago las operaciones con los dos datos, y creo el mensaje de respuesta.

                        enviar.writeUTF(mensaje.mensaje);//Envio la respuesta al cliente.
                        er = 1;
                    } else {
                        if (com.equals(comando2)) {

                            System.out.println(n1);
                            System.out.println(n2);

                            Datos dat2 = new Datos(n1, n2);
                            Datos res2 = dat2.operaciones2(dat2);
                            Mensajes m2 = new Mensajes();
                            mensaje2 = m2.texto2(dat2, res2);

                            enviar.writeUTF(mensaje2.mensaje);
                            er = 1;

                        } else {
                            enviar.writeUTF("\r\nError comando incorrecto.\r\n");
                        }
                    }

                } while (!com.equals("quit"));
            } else {
                enviar.writeUTF("\r\nUsuario o clave incorrectos. \r\n Intentelo de nuevo:\r\n");
                servicio();
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Crea la comunicación mediante sockets, ejecuta la función servicio()para
     * iniciar el servicio y ,finalizado, cierra la conexión.
     */
    public void iniciar() {

        try {

            s1 = new ServerSocket(PUERTO);//Creo un socket servidor, puerto 7000.
            s2 = new Socket();//Creo un socket.

            System.out.println("Esperando conexion...");

            s2 = s1.accept();//Pongo al socket a la escucha en el puerto definido en s1.

            System.out.println("Conexion establecida.");

            recivir = new DataInputStream(s2.getInputStream());//Canal de entrada de datos.

            enviar = new DataOutputStream(s2.getOutputStream());//Canal de esalida de datos.

            enviar.writeUTF("\r\nHola,introduce tus datos:\r\n");

            servicio();

            enviar.writeUTF("Conexion finalizada.");
            System.out.println("Conexion finalizada.");

            s1.close();//Cierro la conexion.

        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
            
        } finally {iniciar();}

    }

}
