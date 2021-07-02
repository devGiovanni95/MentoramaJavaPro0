package br.com.mentorama.exceptions.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    /*Essa configuracao vai ser globlal para todas as classes que implementam a classe RecursoInexistente*/
    @ExceptionHandler({RecursoInexistenteException.class})
    public ResponseEntity<String> handle(final  RecursoInexistenteException e) {
        final String recursoInexistente = "Recurso Inexistente!!!";

        LOGGER.error(recursoInexistente);
//        LOGGER.error(e.getMessage());
        return new ResponseEntity<>(recursoInexistente, HttpStatus.NOT_FOUND);
    }
}
