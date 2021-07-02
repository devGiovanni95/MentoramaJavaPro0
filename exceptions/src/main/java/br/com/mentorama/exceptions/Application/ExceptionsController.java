package br.com.mentorama.exceptions.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exceptions")
public class ExceptionsController {

    final static Logger LOGGER = LoggerFactory.getLogger(ExceptionsController.class);

//    @GetMapping
//    public String findAll() throws RuntimeException {
////        LOGGER.info("Rodou o findAll");
////        LOGGER.debug("Rodou o findAll");
//
//        try {
//            throw new RuntimeException("Eita deu erro.");
//        }catch (Exception e){
//            LOGGER.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return "It's ok.";
//    }

    @GetMapping("/get1")
    public ResponseEntity<String> get1() throws RecursoInexistenteException {
        throw new RecursoInexistenteException();
    }


    @GetMapping("/get2")
    public ResponseEntity<String> get2(){
        throw new RecursoInexistenteException();
    }

//    private ResponseEntity<String> getStringResponseEntity() {
//        try {
//            throw new RecursoInexistenteException();
//        } catch (RecursoInexistenteException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    /*Criado variavel parta a classe existente*/
//    @ExceptionHandler({RecursoInexistenteException.class})
//    public ResponseEntity<String> handle(final  RecursoInexistenteException e) {
//     return new ResponseEntity<>("Recurso inexistente",HttpStatus.NOT_FOUND);
//    }
}
