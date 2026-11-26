package smartclean;
import java.util.Scanner;

public class Smartclean{
    
        public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double[] niveles = new double[5];
        double[][] historial = new double[100][5];

        int opcion, numero, ronda = 0;
        int contador, bajo, medio, alto, recoleccion;

        double suma, promedio, porcentaje;

        // MENU PRINCIPAL
        do {

            System.out.println();
            System.out.println("==================================");
            System.out.println("       SISTEMA SMARTCLEAN");
            System.out.println("    MONITOREO DE CONTENEDORES");
            System.out.println("==================================");
            System.out.println("1. Registrar niveles de llenado");
            System.out.println("2. Consultar un contenedor");
            System.out.println("3. Mostrar estado de contenedores");
            System.out.println("4. Identificar recoleccion");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Mostrar estadisticas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:

                    if (ronda < 100) {

                        ronda++;

                        for (int i = 0; i < 5; i++) {

                            System.out.print("Ingrese el porcentaje del contenedor "
                                    + (i + 1) + ": ");

                            porcentaje = entrada.nextDouble();

                            while (porcentaje < 0 || porcentaje > 100) {

                                System.out.print("Valor incorrecto. "
                                        + "Ingrese un valor entre 0 y 100: ");

                                porcentaje = entrada.nextDouble();
                            }

                            niveles[i] = porcentaje;
                            historial[ronda - 1][i] = porcentaje;
                        }

                        System.out.println("Registro guardado correctamente.");

                    } else {

                        System.out.println("Se alcanzo el limite de registros.");
                    }

                    break;

                case 2:

                    System.out.print("Ingrese el numero del contenedor (1-5): ");
                    numero = entrada.nextInt();

                    if (numero >= 1 && numero <= 5) {

                        System.out.println("Contenedor: " + numero);
                        System.out.println("Nivel de llenado: "
                                + niveles[numero - 1] + "%");

                        if (niveles[numero - 1] < 25) {

                            System.out.println("Estado: BAJO");

                        } else if (niveles[numero - 1] < 50) {

                            System.out.println("Estado: MEDIO");

                        } else if (niveles[numero - 1] < 75) {

                            System.out.println("Estado: ALTO");

                        } else {

                            System.out.println("Estado: REQUIERE RECOLECCION");
                        }

                    } else {

                        System.out.println("Numero de contenedor no valido.");
                    }

                    break;

                case 3:

                    System.out.println("======= ESTADO DE CONTENEDORES =======");

                    for (int i = 0; i < 5; i++) {

                        System.out.println("Contenedor " + (i + 1)
                                + ": " + niveles[i] + "%");

                        if (niveles[i] < 25) {

                            System.out.println("Estado: BAJO");

                        } else if (niveles[i] < 50) {

                            System.out.println("Estado: MEDIO");

                        } else if (niveles[i] < 75) {

                            System.out.println("Estado: ALTO");

                        } else {

                            System.out.println("Estado: REQUIERE RECOLECCION");
                        }
                    }

                    break;

                case 4:

                    contador = 0;

                    System.out.println("=== CONTENEDORES PARA RECOLECCION ===");

                    for (int i = 0; i < 5; i++) {

                        if (niveles[i] >= 75) {

                            System.out.println("Contenedor " + (i + 1)
                                    + " requiere recoleccion.");

                            contador++;
                        }
                    }

                    if (contador == 0) {

                        System.out.println("No hay contenedores pendientes "
                                + "de recoleccion.");

                    } else {

                        System.out.println("Total de contenedores pendientes: "
                                + contador);
                    }

                    break;

                case 5:

                    if (ronda == 0) {

                        System.out.println("Todavia no existen registros.");

                    } else {

                        for (int i = 0; i < ronda; i++) {

                            System.out.println("Registro numero " + (i + 1));

                            for (int j = 0; j < 5; j++) {

                                System.out.println("Contenedor " + (j + 1)
                                        + ": " + historial[i][j] + "%");
                            }
                        }
                    }

                    break;

                case 6:

                    bajo = 0;
                    medio = 0;
                    alto = 0;
                    recoleccion = 0;
                    suma = 0;

                    for (int i = 0; i < 5; i++) {

                        suma = suma + niveles[i];

                        if (niveles[i] < 25) {

                            bajo++;

                        } else if (niveles[i] < 50) {

                            medio++;

                        } else if (niveles[i] < 75) {

                            alto++;

                        } else {

                            recoleccion++;
                        }
                    }

                    promedio = suma / 5;

                    System.out.println("======= ESTADISTICAS =======");
                    System.out.println("Promedio de llenado: "
                            + promedio + "%");
                    System.out.println("Nivel bajo: " + bajo);
                    System.out.println("Nivel medio: " + medio);
                    System.out.println("Nivel alto: " + alto);
                    System.out.println("Requieren recoleccion: "
                            + recoleccion);

                    // Estructura SWITCH para mostrar prioridad

                    switch (recoleccion) {

                        case 0:
                            System.out.println("Prioridad: NORMAL");
                            break;

                        case 1:
                        case 2:
                            System.out.println("Prioridad: MEDIA");
                            break;

                        case 3:
                        case 4:
                        case 5:
                            System.out.println("Prioridad: ALTA");
                            break;
                    }

                    break;

                case 7:

                    System.out.println("Gracias por utilizar SMARTCLEAN.");
                    System.out.println("Sistema finalizado.");

                    break;

                default:

                    System.out.println("Opcion incorrecta. "
                            + "Intente nuevamente.");
            }

        } while (opcion != 7);

        entrada.close();
    }
}
