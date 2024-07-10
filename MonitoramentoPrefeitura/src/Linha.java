/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguel_a_andrade
 */
public class Linha {

    private String linhaNome;
    private int qtdParadas;

    public Linha(int qtdParadas, String linhaNome) {
        this.qtdParadas = qtdParadas;
        this.linhaNome = linhaNome;
    }

    public int getQtdParadas() {
        return qtdParadas;
    }

    public String getLinhaNome() {
        return linhaNome;
    }

    public void setLinhaNome(String linhaNome) {
        this.linhaNome = linhaNome;
    }

    public void setQtdParadas(int qtdParadas) {
        this.qtdParadas = qtdParadas;
    }

    public String toString() {
        return ""
                + this.linhaNome
                + "," + this.qtdParadas + 
                "";
    }

}
