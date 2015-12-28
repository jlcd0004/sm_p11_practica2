package servicios_moviles_e1;

/**
 *
 * @author José Luis Cabeza Díaz
 */
public class Datos {

    int num1 = 0, num2 = 0;
    ;
     
    int res1 = 0, res2 = 0, res3 = 0;

    /**
     * Constructor para los datos que introduce el usuario.
     *
     * @param num1 Primer número entero.
     * @param num2 Segundo número entero.
     */
    public Datos(int num1, int num2) {

        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Constructor para los datos de respuesta del servidor al cliente.
     *
     * @param res1 Suma de los dos enteros.
     * @param res2 Multiplicación de los dos enteros.
     * @param res3 Resta de los dos enteros.
     */
    public Datos(int res1, int res2, int res3) {
        this.res1 = res1;
        this.res2 = res2;
        this.res3 = res3;

    }

    /**
     * Con los datos que envia el usuario, hace suma, multiplicación y resta, y
     * guarda los resultados en un objeto de tipo Datos.
     *
     * @param dat Objeto que contiene los dos enteros con los que se realizarán
     * las operaciones.
     * @return Objeto de la clase Datos con los resultados de las tres
     * operaciones matemáticas.
     */
    public Datos operaciones(Datos dat) {

        int op1 = 0, op2 = 0, sum = 0, mul = 0, res = 0;

        op1 = dat.num1;
        op2 = dat.num2;
        sum = op1 + op2;
        mul = op1 * op2;
        res = op1 - op2;

        Datos oper = new Datos(sum, mul, res);
        return oper;

    }

    /**
     * Con los datos que envia el usuario, hace suma, multiplicación y resta de
     * los cuadrados de los números, y guarda los resultados en un objeto de
     * tipo Datos.
     *
     * @param dat2 Objeto que contiene los dos enteros con los que se realizarán
     * las operaciones.
     * @return Objeto de la clase Datos con los resultados de las tres
     * operaciones matemáticas.
     */
    public Datos operaciones2(Datos dat2) {

        int op1 = 0, op2 = 0, sum2 = 0, mul2 = 0, res2 = 0;
        int op1_2 = 0, op2_2 = 0;

        op1 = dat2.num1;
        op2 = dat2.num2;

        op1_2 = op1 * op1;
        op2_2 = op2 * op2;
        sum2 = op1_2 + op2_2;
        mul2 = op1_2 * op2_2;
        res2 = op1_2 - op2_2;

        Datos oper2 = new Datos(sum2, mul2, res2);
        return oper2;
    }
}
