import java.util.Locale;
import java.util.Scanner;

public class trianguloArea {
        public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Double xA, xB, xC, yA, yB, yC, pX, pY, pX_Total, pY_Total;

        System.out.println("Insira o valor valido do lado A para o triangulo X");
        xA = scanner.nextDouble();
        System.out.println("Insira o valor valido do lado B para o triangulo X");
        xB = scanner.nextDouble();
        System.out.println("Insira o valor valido do lado C para o triangulo X");
        xC = scanner.nextDouble();
        
        System.out.println("Insira o valor valido do lado A para o triangulo Y");
        yA = scanner.nextDouble();
        System.out.println("Insira o valor valido do lado B para o triangulo Y");
        yB = scanner.nextDouble();
        System.out.println("Insira o valor valido do lado C para o triangulo Y");
        yC = scanner.nextDouble();

        pX = (xA + xB + xC)/2;
        pY = (yA + yB + yC)/2;

        pX_Total = Math.sqrt(pX*(pX-xA)*(pX-xB)*(pX-xC));
        pY_Total = Math.sqrt(pY*(pY-yA)*(pY-yB)*(pY-yC));
        
        if (pX_Total > pY_Total) {
            System.out.println("O valor da area do triangulo X e: "+ String.format("%.4f", pX_Total) + " e a area do triangulo Y e: "+ String.format("%.4f", pY_Total)+ " logo a area do triangulo X e maior");
        } else if (pX_Total == pY_Total) {
            System.out.println("O valor da area do triangulo X e: "+ String.format("%.4f", pX_Total) + " e a area do triangulo Y e: "+String.format("%.4f", pY_Total)+ " logo as duas areas sao iguais");
        } else {
            System.out.println("O valor da area do triangulo X e: "+ String.format("%.4f", pX_Total) + " e a area do triangulo Y e: "+ String.format("%.4f", pY_Total)+ " logo a area do triangulo Y e maior");
        }

        
        scanner.close();
    }
}
