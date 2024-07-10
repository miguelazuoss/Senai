
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Sistema {
    ArrayList<Linha> arrayLinhas = getLinhas();
    ArrayList<Onibus> arrayOnibus = getOnibus();
    ArrayList<Viagem> arrayViagem = getViagem();
    
    ////////////////////Recuperar objetos no arquivo.txt//////////////////////////
    public  ArrayList<Linha> getLinhas() {
        ArrayList<Linha> linhas = new ArrayList<>();
        try (FileReader fileReader = new FileReader("registroLinha.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linha;
            ///////////////////////// while para ler linha até encontrar linha vazia ////////////////////////
            while ((linha = bufferedReader.readLine()) != null) {
                ////////////////////// Declara array de String, onde o array vai ser o numero de elementos divididos pelo metodo split onde a cada',' é outro elemento
                String[] linhaArquivo;
                linhaArquivo = linha.split(",");
                Linha linhaDoHistorico = new Linha(Integer.parseInt(linhaArquivo[1]), linhaArquivo[0]);
                linhas.add(linhaDoHistorico);
            }
        } catch (Exception erro) {
            System.out.println("Não há Linhas para ser inicializadas");
        }
        return linhas;
    }
    
    public  ArrayList<Onibus> getOnibus() {
        ArrayList<Onibus> onibus = new ArrayList<>();
        try (FileReader fileReader = new FileReader("registroOnibus.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String onibusString;
            ///////////////////////// while para ler linha até encontrar linha vazia ////////////////////////
            while ((onibusString = bufferedReader.readLine()) != null) {
                String[] onibusArquivo;
                onibusArquivo = onibusString.split(",");

                Onibus onibusDoHistorico = new Onibus(onibusArquivo[0], Integer.parseInt(onibusArquivo[1]));
                onibus.add(onibusDoHistorico);
            }
        } catch (Exception erro) {
            System.out.println("Não há Onibus para ser inicializadas");
        }
        return onibus;
    }
    
    public  ArrayList<Viagem> getViagem() {
        ArrayList<Viagem> viagem = new ArrayList<>();
        try (FileReader fileReader = new FileReader("registroViagem.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String viagemString;
            ///////////////////////// while para ler linha até encontrar linha vazia ////////////////////////
            while ((viagemString = bufferedReader.readLine()) != null) {
                String[] viagemArquivo;
                viagemArquivo = viagemString.split(",");
                Onibus onibusRecuperado = new Onibus(viagemArquivo[2], Integer.parseInt(viagemArquivo[3]));
                Linha linhaRecuperado = new Linha(Integer.parseInt(viagemArquivo[5]), viagemArquivo[4]);
                Viagem viagemDoHistorico = new Viagem(viagemArquivo[0], viagemArquivo[1], onibusRecuperado, linhaRecuperado, Integer.parseInt(viagemArquivo[6]), Integer.parseInt(viagemArquivo[7]));
                viagem.add(viagemDoHistorico);
            }
        } catch (Exception erro) {
        }
        return viagem;
    }
  /////////////////////////////////////////////////////////////////////////////////
    
  //////////////////////////////Salvar Objetos no arquivo.txt/////////////////////////////////
    public void salvarLinha(Linha linhaAtual) throws IOException {
        FileWriter arquivoLinha = new FileWriter("registroLinha.txt", true);
        PrintWriter gravadorLinha = new PrintWriter(arquivoLinha);
        gravadorLinha.println(linhaAtual.toString());
        gravadorLinha.close();

    }

    public void salvarOnibus(Onibus onibusAtual) throws IOException {
        FileWriter arquivoOnibus = new FileWriter("registroOnibus.txt", true);
        PrintWriter gravadorOnibus = new PrintWriter(arquivoOnibus);
        gravadorOnibus.println(onibusAtual.toString());
        gravadorOnibus.close();

    }

    public void salvarViagem(Viagem viagemAtual) throws IOException {
        FileWriter arquivoViagem = new FileWriter("registroViagem.txt", true);
        PrintWriter gravadorViagem = new PrintWriter(arquivoViagem);
        gravadorViagem.println(viagemAtual.toString());
        gravadorViagem.close();
    }
 /////////////////////////////////////////////////////////////////////////////////////////////   
    
    ////////////////////////Escolhas de linha e onibus para iniciar viagem/////////////////////////////////
    public Linha escolhaLinha(){
        int addViagemEscolhaLinha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha qual linha a viagem irá ocorrer\n " + getListLinha() + ""));

        while (((addViagemEscolhaLinha - 1) < 0) || (addViagemEscolhaLinha - 1) >= arrayLinhas.size()) {
            JOptionPane.showMessageDialog(null, "Posição invalida, tente novamente!");
            addViagemEscolhaLinha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha qual linha a viagem irá ocorrer\n " + getListLinha() + ""));
        }

        Linha linhaEscolhida = arrayLinhas.get(addViagemEscolhaLinha - 1);
        
        return linhaEscolhida;
    }
    
    public Onibus escolhaOnibus(Linha linhaEscolhida) {
        int addViagemEscolhaOnibus = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha qual Onibus a viagem irá ocorrer na linha " + linhaEscolhida.getLinhaNome() + "\n " + getListOnibus()+ ""));
        while (((addViagemEscolhaOnibus - 1) < 0) || (addViagemEscolhaOnibus - 1) >= arrayOnibus.size()) {
            JOptionPane.showMessageDialog(null, "Posição invalida!");
            addViagemEscolhaOnibus = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha qual Onibus a viagem irá ocorrer na linha " + linhaEscolhida.getLinhaNome()  + "\n " + getListOnibus() + ""));
        }

        Onibus onibusEscolhido =  arrayOnibus.get(addViagemEscolhaOnibus - 1);

        return onibusEscolhido;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
///////////////////////////Stringbuilder de lista de arrays de objetos/////////////////////////////////////////
    public  StringBuilder getListLinha(){
        StringBuilder listaLinhasBuilder = new StringBuilder();
        listaLinhasBuilder.setLength(0);
        for (int i = 0; i < arrayLinhas.size(); i++) {
            Linha linha = (Linha) arrayLinhas.get(i);
            String posicao = String.valueOf((i + 1) + "- ");
            listaLinhasBuilder.append(posicao);
            listaLinhasBuilder.append(linha.getLinhaNome());
            if (i < arrayLinhas.size() - 1) {
                listaLinhasBuilder.append("\n");
            }
        }
        return listaLinhasBuilder;
    }
    
    public StringBuilder getListOnibus() {
        StringBuilder listaOnibusBuilder = new StringBuilder();
        listaOnibusBuilder.setLength(0);
        for (int i = 0; i < arrayOnibus.size(); i++) {
            Onibus onibus = (Onibus) arrayOnibus.get(i);
            String posicao = String.valueOf((i + 1) + "- ");
            listaOnibusBuilder.append(posicao);
            listaOnibusBuilder.append(onibus.getPlaca());
            if (i < arrayOnibus.size() - 1) {
                listaOnibusBuilder.append("\n");
            }
        }
        return listaOnibusBuilder;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////Criacao de objetos//////////////////////////////////////////////////  
    public Linha criacaoLinha(){
       String addLinhaNome = JOptionPane.showInputDialog(null, "Qual nome de sua linha");
        int addLinhaQtdPar = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas paradas a linha " + addLinhaNome + " vai ter?"));
        arrayLinhas.add(new Linha(addLinhaQtdPar, addLinhaNome));
        Linha linhaAtual = (Linha) arrayLinhas.get(arrayLinhas.size() - 1);
        
        return linhaAtual;
    }
    
    public Onibus criacaoOnibus() {
        String addOnibusPlaca = JOptionPane.showInputDialog(null, "Qual a placa de seu Onibus?");
        int addOnibusQtdMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a quantidade maxima de pessoas o Onibus de placa " + addOnibusPlaca + " vai suportar?"));
        arrayOnibus.add(new Onibus(addOnibusPlaca, addOnibusQtdMax));
        Onibus onibusAtual = (Onibus) arrayOnibus.get(arrayOnibus.size() - 1);

        return onibusAtual;
    }
    
    public Viagem criacaoViagem(String addViagemData, String addViagemHora ){
        Linha linhaEscolhida = escolhaLinha();
        Onibus onibusEscolhido = escolhaOnibus(linhaEscolhida);

        Viagem ultimaViagem = new Viagem(addViagemData, addViagemHora, onibusEscolhido, linhaEscolhida);
        Viagem viagem = criacaoViagem2(ultimaViagem, addViagemData, addViagemHora);
        


        return viagem;
    }
    
    public Viagem criacaoViagem2(Viagem viagemEscolhida, String addViagemData, String addViagemHora ) {
        int index2 = 1;
        for (Viagem e : arrayViagem) {
            Viagem viagemIteracao = e;
            if (viagemIteracao.getLinha().getLinhaNome().equals(viagemEscolhida.getLinha().getLinhaNome())
                    && viagemIteracao.getOnibus().getPlaca().equals(viagemEscolhida.getOnibus().getPlaca())) {
                index2++;
            }   
        }

        Viagem ultimaViagem = new Viagem(addViagemData, addViagemHora, viagemEscolhida.getOnibus(), viagemEscolhida.getLinha(), 0, index2 );
        arrayViagem.add(ultimaViagem);
        arrayViagem = iniciarViagem(ultimaViagem);
        Viagem viagem = (Viagem) arrayViagem.get(arrayViagem.size() - 1);

        return viagem;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////Metodos do funcionamento das viagens ////////////////////////////////////////////
  
    public Viagem listarViagens() {
            StringBuilder totalPassageirosBuilder = new StringBuilder();
            int indexNumerico = 0;
            int index = 0;
            ArrayList<Integer> indexEscolha = new ArrayList<>();
            for (Viagem e : arrayViagem) {
                Viagem viagemIteracao = e;
                if (viagemIteracao.getQtdViagem() == 1 ) {
                    totalPassageirosBuilder.append((indexNumerico + 1))
                            .append("- Viagem da Linha ")
                            .append(viagemIteracao.getLinha().getLinhaNome())
                            .append(" com o Ônibus de Placa ")
                            .append(viagemIteracao.getOnibus().getPlaca())
                            .append("\n");
                    indexEscolha.add(index);
                    indexNumerico++;
                }
                index++;
            }
            int respostaViagemLista = Integer.parseInt(JOptionPane.showInputDialog(null, totalPassageirosBuilder.toString()));
            Viagem viagemEscolhida = arrayViagem.get(indexEscolha.get(respostaViagemLista - 1));
            return viagemEscolhida; 
    }

    public void mostrarViagens(Viagem viagemEscolhida) {
        StringBuilder totalPassageiros2Builder = new StringBuilder();
        for (Viagem e : arrayViagem) {
            Viagem viagemIteracao = e;
            if (viagemIteracao.getLinha().getLinhaNome().equals(viagemEscolhida.getLinha().getLinhaNome())
                    && viagemIteracao.getOnibus().getPlaca().equals(viagemEscolhida.getOnibus().getPlaca())) {
                totalPassageiros2Builder.append("Total de passageiros na ")
                        .append(viagemIteracao.getQtdViagem())
                        .append(" viagem na linha ")
                        .append(viagemIteracao.getLinha().getLinhaNome())
                        .append(" com o ônibus de placa ")
                        .append(viagemIteracao.getOnibus().getPlaca())
                        .append(": ")
                        .append(viagemIteracao.getTotalPassageiros())
                        .append("\n");
               
            }
        }
        JOptionPane.showMessageDialog(null, totalPassageiros2Builder.toString());
    }
    
    public  ArrayList<Viagem> iniciarViagem( Viagem viagemEscolhida) {
        Viagem viagem = viagemEscolhida;
        for (int i = 0; i < viagem.getLinha().getQtdParadas(); i++) {
            descerOnibus(viagem, i);
            subirOnibus(viagem, i);
        }
        return arrayViagem;
    }

    public void descerOnibus(Viagem viagem, int i){
        Random random = new Random();
        
        if (viagem.getOnibus().getQtdAtual() > 0 && !((i + 1) == viagem.getLinha().getQtdParadas())) {
            int numeroAleatorio = random.nextInt(viagem.getOnibus().getQtdAtual());
            viagem.getOnibus().setQtdAtual(viagem.getOnibus().qtdAtual - numeroAleatorio);
            JOptionPane.showMessageDialog(null, "Na " + (i + 1) + " parada do Onibus de placa " + viagem.getOnibus().getPlaca() + " na linha " + viagem.getLinha().getLinhaNome() + " que contêm " + viagem.getLinha().getQtdParadas() + " paradas:\n\n Quantidade de Passageiros que desceram: " + numeroAleatorio + "\n Quantidade Atual: " + viagem.getOnibus().getQtdAtual());
        }
        if ((i + 1) == viagem.getLinha().getQtdParadas() && viagem.getOnibus().getQtdAtual() > 0) {
            JOptionPane.showMessageDialog(null, "Na " + (i + 1) + " parada do Onibus de placa " + viagem.getOnibus().getPlaca() + " na linha " + viagem.getLinha().getLinhaNome() + " que contêm " + viagem.getLinha().getQtdParadas() + " paradas:\n\n Quantidade de Passageiros que desceram: " + viagem.getOnibus().getQtdAtual() + "\n Quantidade Atual: 0");
            viagem.getOnibus().setQtdAtual(0);
        }
    }
    
    public void subirOnibus(Viagem viagem, int i) {
        Random random = new Random();

        int numeroAleatorio = random.nextInt(30);
        if (!((i + 1) == viagem.getLinha().getQtdParadas())) {
            if (viagem.getOnibus().getQtdMax() > viagem.getOnibus().getQtdAtual()) {
                if (viagem.getOnibus().getQtdMax() > (viagem.getOnibus().getQtdAtual() + numeroAleatorio)) {
                    viagem.getOnibus().setQtdAtual((viagem.getOnibus().getQtdAtual() + numeroAleatorio));
                    viagem.setTotalPassageiros(viagem.getTotalPassageiros() + numeroAleatorio);
                    JOptionPane.showMessageDialog(null, "Na " + (i + 1) + " parada do Onibus de placa " + viagem.getOnibus().getPlaca() + " na linha " + viagem.getLinha().getLinhaNome() + " que contêm " + viagem.getLinha().getQtdParadas() + " paradas:\n\n Quantidade de Passageiros que subiram: " + numeroAleatorio + "\n Quantidade Atual: " + viagem.getOnibus().getQtdAtual());
                } else {
                    int numeroDisponivel = viagem.getOnibus().getQtdMax() - viagem.getOnibus().getQtdAtual();
                    viagem.getOnibus().setQtdAtual((viagem.getOnibus().getQtdAtual() + numeroDisponivel));
                    viagem.setTotalPassageiros(viagem.getTotalPassageiros() + numeroDisponivel);
                    JOptionPane.showMessageDialog(null, "Na " + (i + 1) + " parada do Onibus de placa " + viagem.getOnibus().getPlaca() + " na linha " + viagem.getLinha().getLinhaNome() + " que contêm " + viagem.getLinha().getQtdParadas() + " paradas:\n\n Quantidade de Passageiros que subiram: " + numeroDisponivel + "\n Quantidade Atual: " + viagem.getOnibus().getQtdAtual() + "\n Quantidade que não conseguiu subir devido ao Onibus Cheio: " + (numeroAleatorio - numeroDisponivel));
                }
            } else {
                JOptionPane.showMessageDialog(null, "O onibus estava cheio, " + numeroAleatorio + " pessoas não conseguiram subir na " + (i + 1) + " parada \n\n Quantidade Maxima: " + viagem.getOnibus().getQtdMax() + "\nQuantidade Atual" + viagem.getOnibus().getQtdAtual());
            }
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
