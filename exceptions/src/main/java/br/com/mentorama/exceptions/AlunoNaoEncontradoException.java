package br.com.mentorama.exceptions;

public class AlunoNaoEncontradoException extends Exception {
    //extends Exceptions para precisar de tratamento
    //extends RunTimeExceptions para nao precisar de tratamento

    public AlunoNaoEncontradoException(final  String nome){
        super("Nome " + nome +
                 " não encontrado!");
    }
}
