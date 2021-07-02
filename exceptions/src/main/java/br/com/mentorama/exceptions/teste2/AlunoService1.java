package br.com.mentorama.exceptions.teste2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AlunoService1 {

    public void findAll() {
        File arquivo = new File("C:\\ProjetosJava\\MentoramaJavaPro\\exceptions\\src\\main\\resources\\aluno.txt");

        Scanner scanner = null;

        try {
            scanner = new Scanner(arquivo);//ler arquivo
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            /*checked runtime*/
        } catch (IOException ioException) {
            throw new RuntimeException("Arquivo não encontrado");/*transforma numa unchecked rumtime excessao*/
        }
    }
    

}