import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class trianguloArea {
        public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        //double xA, xB, xC, yA, yB, yC, pX, pY, pX_Total, pY_Total;
/* 
        double pX, pY, pX_Total, pY_Total; */

        Triangle x, y;

        x = new Triangle();
        y = new Triangle();
        
        System.out.println("Insira os valores validos para o triangulo X");
        x.a = scanner.nextDouble();
        x.b = scanner.nextDouble();
        x.c = scanner.nextDouble();

        System.out.println("Insira os valores validos para o triangulo Y");
        y.a = scanner.nextDouble();
        y.b = scanner.nextDouble();
        y.c = scanner.nextDouble();

/*      System.out.println("Insira o valor valido do lado A para o triangulo X");
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
        yC = scanner.nextDouble(); */

/*      pX = (x.a + x.b + x.c)/2;
        pY = (y.a + y.b + y.c)/2; */
    
/*      pX = (xA + xB + xC)/2;
        pY = (yA + yB + yC)/2; */

/*         pX_Total = Math.sqrt(pX*(pX-x.a)*(pX-x.b)*(pX-x.c));
        pY_Total = Math.sqrt(pY*(pY-y.a)*(pY-y.b)*(pY-y.c)); */

        double areaX = x.area();
        double areaY = x.area();
        
        if (areaX > areaY) {
            System.out.println("O valor da area do triangulo X e: "+ String.format("%.4f", areaX) + " e a area do triangulo Y e: "+ String.format("%.4f", areaY)+ " logo a area do triangulo X e maior");
        } else if (pX_Total == areaY) {
            System.out.println("O valor da area do triangulo X e: "+ String.format("%.4f", areaX) + " e a area do triangulo Y e: "+String.format("%.4f", areaY)+ " logo as duas areas sao iguais");
        } else {
            System.out.println("O valor da area do triangulo X e: "+ String.format("%.4f", areaX) + " e a area do triangulo Y e: "+ String.format("%.4f", areaY)+ " logo a area do triangulo Y e maior");
        }       */
       scanner.close(); 
    }
}
