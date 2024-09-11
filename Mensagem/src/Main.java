import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
    //Declaração de variaveis
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultadob;




    public Main(){
        //Configuração do Frame
        setTitle("Calculadora");
        setSize(1000, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Modo de fechamento
        setLocationRelativeTo(null);
        // Todos metodos de frame diretamente por conta de estar extendendo
        
        //Caracteristicas do panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        JButton addbotao = new JButton("Adicionar");
        JButton subtrairbotao = new JButton("Subtrair");
        JButton multibotao = new JButton("Multiplicar");
        JButton divbotao = new JButton("Dividir");
        resultadob = new JLabel("Resultado");

        panel.add(new JLabel("Numero 1"));
        panel.add(num1Field);
        panel.add(new JLabel("Numero 2"));
        panel.add(num2Field);
        panel.add(addbotao);
        panel.add(subtrairbotao);
        panel.add(multibotao);
        panel.add(divbotao);
        panel.add(resultadob);
        add(panel);

        addbotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('+');
            }
        });

        subtrairbotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('-');
            }
        });

        multibotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('*');
            }
        });

        divbotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                operacaoMatematica('/');
            }
        });
    }

    private void operacaoMatematica(char operador){
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double resultado = 0;

            switch (operador){
                case'+': resultado = num1+num2; break;
                case'-': resultado = num1-num2; break;
                case'*': resultado = num1*num2; break;
                case'/': 

                    if(num2 != 0){
                        resultado = num1/num2;
                    }else{
                        resultadob.setText("Erro Divisão por Zero");
                        return;
                    } 
                break;
            }

        resultadob.setText("Resultado: "+resultado);
        } catch (Exception e) {
            resultadob.setText("Erro: Entrada Inválida");
        }

    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
