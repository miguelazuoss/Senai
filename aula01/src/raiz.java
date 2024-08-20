import java.util.Locale;
import java.util.Scanner;

public class raiz {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Double raiz;

        System.out.println("Insira o numero para adquirir a raiz quadrada");
        raiz = scanner.nextDouble();
        

        System.out.printf("Sua raiz quadrada do numero "+ raiz + " é: %.2f", (Math.sqrt(raiz)));
        
        scanner.close();
    }


}
