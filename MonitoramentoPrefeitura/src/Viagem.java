
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author miguel_a_andrade
 */
public class Viagem {

    private String data, horario;
    private Onibus onibus;
    private Linha linha;
    public int totalPassageiros = 0;
    private int qtdViagem = 1;

    public Viagem(String data, String horario, Onibus onibus, Linha linha) {
        this.data = data;
        this.horario = horario;
        this.onibus = onibus;
        this.linha = linha;
        this.totalPassageiros = 0;
    }
    
        public Viagem(String data, String horario, Onibus onibus, Linha linha, int totalPassageiros) {
        this.data = data;
        this.horario = horario;
         this.onibus = onibus;
        this.linha = linha;
        this.totalPassageiros = totalPassageiros;
    }

     public Viagem(String data, String horario, Onibus onibus, Linha linha, int totalPassageiros, int qtdViagem) {
        this.data = data;
        this.horario = horario;
        this.onibus = onibus;
        this.linha = linha;
        this.totalPassageiros = totalPassageiros;
        this.qtdViagem = qtdViagem;
    }
        
    public int getQtdViagem() {
        return qtdViagem;
    }

    public void setQtdViagem(int qtdViagem) {
        this.qtdViagem = qtdViagem;
    }  

    public String getData() {
        return data;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public int getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(int totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }
    
    public String toString(){
        return  "" 
                + this.data +
                "," + this.horario +
                "," + this.onibus +
                "," + this.linha + 
                "," + this.totalPassageiros + 
                "," + this.qtdViagem +
                "";
    }
}
