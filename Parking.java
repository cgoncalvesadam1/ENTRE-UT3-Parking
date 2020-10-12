
/**
 * La clase representa a un parking de una ciudad europea
 * que dispone de dos tarifas de aparcamiento para los clientes
 * que lo usen: la tarifa regular (que incluye una tarifa plana para
 * entradas "tempranas") y la tarifa comercial para clientes que trabajan
 * cerca del parking, aparcan un nº elevado de horas y se benefician de esta 
 * tarifa más económica
 * (leer enunciado)
 * @autor: Catarina Gonçalves Almeida
 */
public class Parking
{
    private final char REGULAR = 'R';
    private final char COMERCIAL = 'C';
    private final double PRECIO_BASE_REGULAR = 2.0;
    private final double PRECIO_MEDIA_REGULAR_HASTA11 = 3.0;
    private final double PRECIO_MEDIA_REGULAR_DESPUES11 = 5.0;
    private final int HORA_INICIO_ENTRADA_TEMPRANA = 6 * 60;
    private final int HORA_FIN_ENTRADA_TEMPRANA = 8 * 60 + 30;
    private final int HORA_INICIO_SALIDA_TEMPRANA = 15 * 60;
    private final int HORA_FIN_SALIDA_TEMPRANA = 18 * 60;
    private final double PRECIO_TARIFA_PLANA_REGULAR = 15.0;
    private final double PRECIO_PRIMERAS3_COMERCIAL = 5.00;
    private final double PRECIO_MEDIA_COMERCIAL = 3.00;
    private String nombre;
    private int cliente;
    private double importeTotal;
    private int regular;
    private int comercial;
    private int clientesLunes;
    private int clientesSabado; 
    private int clientesDomingo;
    private int clienteMaximoComercial;
    private double importeMaximoComercial;

    /**
     * Inicializa el parking con el nombre indicada por el parámetro.
     * El resto de atributos se inicializan a 0 
     */
    public Parking(String queNombre) {
        nombre = queNombre;
        cliente = 0;
        importeTotal = 0;
        regular = 0;
        comercial = 0;
        clientesLunes = 0;
        clientesSabado = 0;
        clientesDomingo = 0;
        clienteMaximoComercial = 0;
        importeMaximoComercial = 0;
    }

    /**
     * accesor para el nombre del parking
     *  
     */
    public String getNombre () {
        return nombre;
    }

    /**
     * mutador para el nombre del parking
     *  
     */
    public void setNombre (String queNombre) {
        nombre = queNombre;
    }

    /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    tipoTarifa - un carácter 'R' o 'C'
     *    entrada - hora de entrada al parking
     *    salida – hora de salida del parking
     *    dia – nº de día de la semana (un valor entre 1 y 7)
     *    
     *    A partir de estos parámetros el método debe calcular el importe
     *    a pagar por el cliente y mostrarlo en pantalla 
     *    y  actualizará adecuadamente el resto de atributos
     *    del parking para poder mostrar posteriormente (en otro método) las estadísticas
     *   
     *    Por simplicidad consideraremos que un cliente entra y sale en un mismo día
     *    
     *    (leer enunciado del ejercicio)
     */
    public void facturarCliente(char tipoTarifa, int entrada, int salida, int dia) {
        int horasParaEntrar = entrada / 100; 
        int minutosParaEntrar = entrada % 100;
        int horasParaSalir = salida / 100;
        int minutosParaSalir = salida % 100;
        int tiempoentrada = horasParaEntrar * 60 + minutosParaEntrar;
        String str1  = ":" ;
        String str2 = horasParaEntrar + str1 + minutosParaEntrar;
        String str3 = horasParaSalir + str1 + minutosParaSalir;
        String minutosParaEntrarPt;
        cliente++;
        if (minutosParaEntrar < 10) {
            minutosParaEntrarPt = "0" + minutosParaEntrar;
        }
        switch(tipoTarifa){
            case 'R': if(entrada >= HORA_INICIO_ENTRADA_TEMPRANA && entrada < HORA_FIN_ENTRADA_TEMPRANA && 
            salida >= HORA_INICIO_SALIDA_TEMPRANA && salida < HORA_INICIO_SALIDA_TEMPRANA){
                System.out.println("*********************************");
                System.out.println("cliente nº:" + cliente);
                System.out.println("hora entrada:" + str2);
                System.out.println("hora salida:" + str3);
                System.out.println("tarifa a aplicar:" + tipoTarifa);
                System.out.println("importe a pagar:" + "€");
                System.out.println("*********************************");
            }
            else if(entrada < HORA_INICIO_ENTRADA_TEMPRANA && entrada >= HORA_FIN_ENTRADA_TEMPRANA && 
            salida < HORA_INICIO_SALIDA_TEMPRANA && salida >= HORA_INICIO_SALIDA_TEMPRANA){
                System.out.println("*********************************");
                System.out.println("cliente nº:" + cliente);
                System.out.println("hora entrada:" + str2);
                System.out.println("hora salida:" + str3);
                System.out.println("tarifa a aplicar:" + tipoTarifa);
                System.out.println("importe a pagar:" + "€");
                System.out.println("*********************************");
            }
            break;
            case 'C':if((salida - entrada) <= 100){
                System.out.println("*********************************");
                System.out.println("cliente nº:" + cliente);
                System.out.println("hora entrada:" + str2);
                System.out.println("hora salida:" + str3);
                System.out.println("tarifa a aplicar:" + tipoTarifa);
                System.out.println("importe a pagar:" + "€");
                System.out.println("*********************************");
            }
            break;
        }
    }

    /**
     * Muestra en pantalla las estadísticcas sobre el parking  
     *   
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {

    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que más clientes han utilizado el parking - "SÁBADO"   "DOMINGO" o  "LUNES"
     */
    public String diaMayorNumeroClientes() {
        if (clientesSabado > clientesLunes && clientesSabado > clientesDomingo){
            return "DOMINGO";}
        else if (clientesSabado > clientesLunes ){
            return "SÁBADO" ;}
        else {
            return "LUNES";
        }
    }
}
