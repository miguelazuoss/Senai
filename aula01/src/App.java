import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Double peso, altura;

        System.out.println("Insira seu peso em KG");
        peso = scanner.nextDouble();
        
        System.out.println("Insira sua altura em M");
        altura = scanner.nextDouble();

        System.out.printf("Seu imc é "+"%.2f", (peso/(altura*altura)) );
        
        scanner.close();
    }
}
