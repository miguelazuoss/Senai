import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Estoque {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();
        System.out.println("Enter product data");
        produto.name = scanner.nextLine();
        produto.price = scanner.nextDouble();
        produto.quantity = scanner.nextInt();

        System.out.println("Product data: " + produto.name + ", $ "+ produto.price +", "+ produto.quantity + " units"+ ", Total: "+produto.TotalValueStock());
       
        System.out.println("Enter the numbers of product to be added in stock");
        int newAdd = scanner.nextInt();
        produto.AddProducts(newAdd);
        
        System.out.println("Update data: " + produto.name + ", $ "+ produto.price +", "+ produto.quantity + " units"+ ", Total: "+produto.TotalValueStock());
        
        System.out.println("Enter the numbers of product to be removed in stock");
        int removeAdd = scanner.nextInt();
        produto.RemoveProducts(removeAdd);
        
        System.out.println("Update data: " + produto.name + ", $ "+ produto.price +", "+ produto.quantity + " units"+ ", Total: "+produto.TotalValueStock());
    }
}
