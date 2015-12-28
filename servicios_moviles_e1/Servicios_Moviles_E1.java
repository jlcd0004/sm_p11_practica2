package servicios_moviles_e1;

/**
 *
 * @author José Luis Cabeza Díaz
 */
public class Servicios_Moviles_E1 {

    /**
     * Aqui se llama a la función iniciar(), a partir de la cual se ejecuta el
     * resto del código.
     *
     * Para introducir laos datos de usuario hay que introducir: 1º. usr usuario
     * 2º. pas 1234
     *
     * Despues, para usar el servicio, hay que introducir: opera num1 num2 (para
     * operaciones normales) ó opera2 num1 num2 (para operaciones con los
     * cuadrados de los números). Y quit para salir.
     *
     * Siendo num1 y num2 los números a los cuales se les desea hacer las
     * operaciones.
     *
     * @param args
     */
    public static void main(String[] args) {

        Metodos ini = new Metodos();
        ini.iniciar();

    }

}
