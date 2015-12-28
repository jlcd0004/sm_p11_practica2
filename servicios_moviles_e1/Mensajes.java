package servicios_moviles_e1;

/**
 *
 * @author José Luis Cabeza Díaz
 */
public class Mensajes {

    String mensaje;

    /**
     * Constructor vacio para llamarlo a la hora de llamar a la función
     * texto(datC,datR).
     */
    public Mensajes() {
    }

    /**
     * Constructor para crear un objeto de la clase Mensajes.
     *
     * @param mensaje El string que formará el mensaje.
     */
    public Mensajes(String mensaje) {

        this.mensaje = mensaje;
    }

    /**
     * En esta función pasa los datos a string, forma un mensaje de respuesta y
     * con este crea un objeto de tipo Mensajes.
     *
     * @param datC Objeto de la clase Datos con los dos enteros del cliente.
     * @param datR Objeto de la clase Datos con las respuestas de las tres
     * operaciones matemáticas.
     * @return Objeto de la clase Mensajes que contiene un string con la
     * respuesta del servidor al usuario.
     */
    public Mensajes texto(Datos datC, Datos datR) {

        String txt = "";

        String d1 = Integer.toString(datC.num1);
        String d2 = Integer.toString(datC.num2);
        String r1 = Integer.toString(datR.res1);
        String r2 = Integer.toString(datR.res2);
        String r3 = Integer.toString(datR.res3);

        txt = "Sum: " + r1 + " Mul: " + r2 + " Res: " + r3 + "\r\n";
        Mensajes texto = new Mensajes(txt);

        return texto;
    }

    /**
     * En esta función pasa los datos a string, forma un mensaje de respuesta y
     * con este crea un objeto de tipo Mensajes.
     *
     * @param datC2 Objeto de la clase Datos con los dos enteros del cliente.
     * @param datR2 Objeto de la clase Datos con las respuestas de las tres
     * operaciones matemáticas.
     * @return Objeto de la clase Mensajes que contiene un string con la
     * respuesta del servidor al usuario.
     */
    public Mensajes texto2(Datos datC2, Datos datR2) {

        String txt2 = "";

        String d1_2 = Integer.toString(datC2.num1);
        String d2_2 = Integer.toString(datC2.num2);
        String r1_2 = Integer.toString(datR2.res1);
        String r2_2 = Integer.toString(datR2.res2);
        String r3_2 = Integer.toString(datR2.res3);

        txt2 = "Sum2: " + r1_2 + " Mul2: " + r2_2 + " Res2: " + r3_2 + "\r\n";
        Mensajes texto2 = new Mensajes(txt2);

        return texto2;
    }

}
