package entities;

public class Produto {
    public String name;
    public double price;
    public int quantity;

    public double TotalValueStock(){
        return (this.quantity * this.price);
    }

    public void AddProducts(int param){
        this.quantity += param;
    }
    
    public void RemoveProducts(int param){
        this.quantity -= param;
    }
    
}
