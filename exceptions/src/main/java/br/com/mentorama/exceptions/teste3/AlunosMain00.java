package br.com.mentorama.exceptions.teste3;


import br.com.mentorama.exceptions.AlunoNaoEncontradoException;

import java.net.URISyntaxException;

public class AlunosMain00 {

    public static void main(String[] args)  {

//        AlunoService alunoService = new AlunoService();
//        alunoService.findAll().stream().forEach(System.out::println);

//        AlunoService00 alunoService = new AlunoService00();
//        try {
//            alunoService.findAll().stream().forEach(System.out::println);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        try {
            final String aluno = new AlunoService00().findAluno("Aluno 1");
            System.out.println(aluno);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (AlunoNaoEncontradoException e) {
            e.printStackTrace();
        }


    }
}