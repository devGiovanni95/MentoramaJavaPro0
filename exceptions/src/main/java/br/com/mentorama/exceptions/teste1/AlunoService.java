package br.com.mentorama.exceptions.teste1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlunoService {

    //erro no patch
//    public List<String> findAll()  {
//        String caminho = AlunoService.class.getClassLoader()
//                .getResource("alunos.txt").getPath();
//
//        try {
//            List<String> alunos = Files.readAllLines(Path.of(caminho));
//            return alunos;
//        }catch (IOException ioException){
//            return Collections.emptyList();
//        }
//    }C:\ProjetosJava\MentoramaJavaPro\exceptions\target\classes

    public void findAll() {
        File arquivo = new File("C:\\ProjetosJava\\MentoramaJavaPro\\exceptions\\src\\main\\resources\\alunos.txt");

        Scanner scanner = null;

//        try {
//           scanner = new Scanner(arquivo);//ler arquivo
//            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//                throw new RuntimeException("Eita deu erro");
//            }
//        }catch (IOException ioException){
////            ioException.printStackTrace();            pode usar esse para capturar a excessao
//            System.out.println("Error: " + ioException.getMessage());
//        }catch (Exception exception){
//            /* Com a Exception e da classe pai das excessoes
//             qualquer outra excessao que for filha ele ira
//             capturar mostrando assim no console e mostrara
//             no console a mensagem que deixamos ele printar na tela*/
//            exception.printStackTrace();
//        }
//
//

        try {
            scanner = new Scanner(arquivo);//ler arquivo
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
//                throw new RuntimeException("Eita deu erro");          teste de erro
            }
        } catch (IOException | RuntimeException ioException) {
            ioException.printStackTrace();
//            System.out.println("Error: " + ioException.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("Executando o finally");
            }
        }
    }
}