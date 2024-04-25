import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        DivisasMap divisasMap = new DivisasMap();

        boolean conversion = true;

        while (conversion) {
            System.out.println("Bienvenido al convertidor de divisas.");
            System.out.println("Ingrese la divisa que desea convertir:");
            System.out.println("1. USD \n 2. ARS \n 3. EUR \n 4. BRL \n 5. CLP \n 6. COP \n 7. Salir");
            var base = lectura.nextLine();

            base = divisasMap.getAbreviatura(base);

            if (!base.equals("Salir")) {
                System.out.println("Eligió: " + base);
                System.out.println("Ingrese la divisa a la que desea convertir " + base + ":");
                System.out.println("1. USD \n 2. ARS \n 3. EUR \n 4. BRL \n 5. CLP \n 6. COP \n 7. Salir");
                var objetivo = lectura.nextLine();

                objetivo = divisasMap.getAbreviatura(objetivo);

                if (!objetivo.equals("Salir")) {
                    System.out.println("Ingrese el monto a convertir:");
                    var monto = lectura.nextLine();

                    Divisas divisas = consulta.setDivisa(base, objetivo, monto);
                    System.out.println("*******************************");
                    System.out.printf("1 %s equivale a %.2f %s. \n", base, divisas.conversion_rate(), objetivo);
                    System.out.printf("%s %s equivale a %.2f %s \n", monto, base, divisas.conversion_result(), objetivo);
                    System.out.println("*******************************");


                } else {
                    System.out.println("Finalizando programa.");
                    conversion = false;
                }
            } else {
                System.out.println("Finalizando programa.");
                conversion = false;
            }
        }
    }
}
