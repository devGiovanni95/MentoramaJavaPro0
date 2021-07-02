package br.com.mentorama.exceptions.teste3;

import br.com.mentorama.exceptions.AlunoNaoEncontradoException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlunoService00 {

    public List<String> findAll() throws URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String caminho;

        try {
          caminho = Paths.get(classLoader.getResource("alunos.txt").toURI()).toString();

          List<String> alunos = Files.readAllLines(Paths.get(caminho));
          return alunos;

        } catch (IOException ioException) {
            return Collections.emptyList();
        }
    }
//    public String findAluno(String nome) throws URISyntaxException, AlunoNaoEncontradoException {
//        return findAll().stream()
//                .filter(aluno -> aluno.equals(nome))
//                .findFirst()
//                .orElseThrow(() -> new AlunoNaoEncontradoException(nome));
//    }
//
    public String findAluno(String nome) throws URISyntaxException, AlunoNaoEncontradoException {
        return findAll().stream()
                .filter(aluno -> aluno.equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(nome));
    }
}