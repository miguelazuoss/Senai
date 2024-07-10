import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author miguel_a_andrade
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Sistema sistemaClass = new Sistema();
        int respostaMenu = 0;
        ArrayList<Linha> arrayLinhas = sistemaClass.arrayLinhas;
        ArrayList<Onibus> arrayOnibus = sistemaClass.arrayOnibus;
        ArrayList<Viagem> arrayViagem = sistemaClass.arrayViagem;
        

        while (respostaMenu != 5) {
            respostaMenu = (Integer.parseInt(JOptionPane.showInputDialog(null, 
"""
                                                                        Menu Monitoramento Onibus 
 1-Cadastrar Linha | 2-Cadastrar Onibus | 3-Iniciar nova Viagem | 4-Ver Total de Passageiros por Viagem  | 5-Sair
"""
            )));
            
            switch (respostaMenu) {
                case 1:
                    Linha linhaAtual = sistemaClass.criacaoLinha();
                    sistemaClass.salvarLinha(linhaAtual);
                    break;
                case 2:
                    Onibus onibusAtual = sistemaClass.criacaoOnibus();
                    sistemaClass.salvarOnibus(onibusAtual);
                    break;
                case 3: 
                    int resposta3opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "                                            Você deseja:\n1-Iniciar com nova Viagem | 2-Iniciar uma Viagem já existente"));
                    switch(resposta3opcao){
                        case 1:
                            if (arrayOnibus.isEmpty() || arrayLinhas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Você não possui Onibus/Linhas Suficientes");
                            } else {
                                String addViagemData = JOptionPane.showInputDialog(null, "Qual foi a data que essa viagem se iniciou?\n  Informe no formato dd/mm/ano");
                                String addViagemHora = JOptionPane.showInputDialog(null, "Qual a hora que essa viagem se iniciou?\n  Informe no formato hh:min");
                                Viagem viagem = sistemaClass.criacaoViagem(addViagemData,addViagemHora );
                                sistemaClass.salvarViagem(viagem);
                            }
                            break;
                        case 2:
                            if (arrayViagem.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Você não possui Viagems cadastradas suficientes");
                            } else {
                                Viagem viagemEscolhida = sistemaClass.listarViagens();
                                String addViagemData = JOptionPane.showInputDialog(null, "Qual foi a data que essa viagem se iniciou?\n  Informe no formato dd/mm/ano");
                                String addViagemHora = JOptionPane.showInputDialog(null, "Qual a hora que essa viagem se iniciou?\n  Informe no formato hh:min");
                                Viagem viagemFinal = sistemaClass.criacaoViagem2(viagemEscolhida, addViagemData, addViagemHora);
                                sistemaClass.salvarViagem(viagemFinal);
                            }
                            break;
                    }
                    break;
                case 4:
                    if (!arrayViagem.isEmpty()) {
                        Viagem viagemEscolhida = sistemaClass.listarViagens();
                        sistemaClass.mostrarViagens(viagemEscolhida);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sem viagens anteriores");
                    }
                    break;
                case 5:
                    respostaMenu = 5;
                    break;
            }
        }
    }
}

/////////////////////Possivel trycatch function///////////////////////
//   public static Object inputPane(String retornoTipo, String message) {
//        String input = JOptionPane.showInputDialog(null, message);
//
//        switch (retornoTipo) {
//            case "String":
//                return input;
//
//            case "int":
//                try {
//                    return Integer.parseInt(input);
//                } catch (NumberFormatException e) {
//                    JOptionPane.showMessageDialog(null, "Entrada ou Opção inválida! Tente novamente!");
//                    return null; // ou outra ação apropriada em caso de erro
//                }
//        }
//        return input;
//}
//////////////////////////////////////////////////////////USANDO SUBSTRING E INDEXOF(COMPLEXIDADE SEM RAZAO)////////////////////////////////////
//    public static ArrayList<Onibus> getOnibus() {
//        ArrayList<Onibus> onibus = new ArrayList<>();
//        try (FileReader fileReader = new FileReader("registroOnibus.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            String onibusString;
//            ///////////////////////// while para ler linha até encontrar linha vazia ////////////////////////
//            while ((onibusString = bufferedReader.readLine()) != null) {
//                ////////////////////////Extrai substring(metodo que extrai partes da string total) substring([quando se inicia a sua substring], [quando termina a substring que vc quer pegar]), usa o indexOf pegar o index do inicio da string em uma string a primeira ocorrência da string que vc quer)
//                String placa = onibusString.substring(onibusString.indexOf("placa=")+6,onibusString.indexOf(","));
//                int Segunda = onibusString.indexOf(",");
//                int qtdMax = Integer.parseInt(onibusString.substring(onibusString.indexOf("qtdMax=") + 7, onibusString.indexOf(",", Segunda+1)));
//
//                Onibus OnibusDoHistorico = new Onibus(placa, qtdMax);
//                onibus.add(OnibusDoHistorico);
//            }
//        } catch (Exception erro) {
//           System.out.println("Não há Linhas para ser inicializadas");
//        }
//        return onibus;