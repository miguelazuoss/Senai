/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguel_a_andrade
 */
public class Onibus {
    private String placa;
    private int qtdMax;
    public int qtdAtual;
    
    public Onibus(String placa, int qtdMax){
      this.placa = placa;
      this.qtdMax = qtdMax;
      this.qtdAtual = 0;
    }
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }
    
    public String toString() {
        return ""
                + this.placa
                + "," + this.qtdMax + 
                "";
    }
    
}
