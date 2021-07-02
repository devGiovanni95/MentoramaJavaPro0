package br.com.mentorama.exceptions.teste1;


import br.com.mentorama.exceptions.teste2.AlunoService1;

public class AlunosMain {

    public static void main(String[] args) {

//        AlunoService alunoService = new AlunoService();
//        alunoService.findAll().stream().forEach(System.out::println);
//
//        AlunoService alunoService = new AlunoService();
//        alunoService.findAll();
//        System.out.println("Finish");
//
        AlunoService1 alunoService1 = new AlunoService1();
        alunoService1.findAll();
    }
}