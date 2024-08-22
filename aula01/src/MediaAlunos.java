import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

import entities.NotasMedia;

public class MediaAlunos {
    
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<NotasMedia> notasDosAlunos =  new ArrayList<>();
        int alunos;

        System.out.println("Quantos alunos voce quer calcular a media?");
        alunos = scanner.nextInt();

        for(int j = 0; j<alunos; j++){
            NotasMedia notasAluno = new NotasMedia();
                System.out.println("Insira as quatro notas do "+ (j+1)+" aluno");
                notasAluno.n1 = scanner.nextDouble();
                notasAluno.n2 = scanner.nextDouble();
                notasAluno.n3 = scanner.nextDouble();
                notasAluno.n4 = scanner.nextDouble();
                notasDosAlunos.add(notasAluno);
        }
        for(int j = 0; j<alunos; j++){
                if(notasDosAlunos.get(j).media() >= 7.0){
                    System.out.println("Aluno "+ (j+1)+" com media: "+ notasDosAlunos.get(j).media()+ " esta aprovado");
                } else {
                    System.out.println("Aluno "+ (j+1)+" com media: "+ notasDosAlunos.get(j).media()+ " esta reprovado");
                }
        }
      }
}
